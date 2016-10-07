package com.ttm.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ttm.biz.StoreBiz;
import com.ttm.biz.impl.StoreBizImpl;
import com.ttm.enums.SortStatuseEnum;
import com.ttm.orm.Store;

@Controller
public class StoreAction {

	private StoreBiz storeBiz = new StoreBizImpl();

	private ModelAndView view = new ModelAndView();
	
	private static final Logger logger = Logger.getLogger(StoreAction.class);

	/**
	 * 进入问题反馈
	 * @return
	 */
	@RequestMapping(value = "contact", method = RequestMethod.GET)
	public String editContact() {
		return "/contact";
	}
	
	/**
	 * 保存/修改店铺
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "store/{id}", method = RequestMethod.POST)
	public String editStoreStatus(HttpServletRequest request) {
		String id = request.getParameter("id");
		String webType = request.getParameter("webType");
		
		Store store = storeBiz.findById(Integer.valueOf(id));
		if (store != null) {
			switch (webType) {
			case "editStatus":
				String status = request.getParameter("status");
				store.setStatus(Integer.valueOf(status));
				break;
			case "editRecruitment":
				String recruitment = request.getParameter("recruitment");
				store.setRecruitment(Integer.valueOf(recruitment));
			default:
				break;
			}
			
			if (storeBiz.updateStore(store)) {
				logger.info("修改成功");
			} else {
				logger.info("修改失败");
			}
		} else {
			logger.info("查询数据wei null");
		}
		
		return "redirect:/store?page=1&size=25";
	}
	
	/**
	 * 进入编辑兼职页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "store/{id}/recruitment", method = RequestMethod.GET)
	public ModelAndView editRecruitment(@PathVariable("id") Integer id) {
		Store store = storeBiz.findById(id);
		if (store != null) {
			Map<Integer, String[]> recruitmentSelect = storeBiz.fetchSelectRecruitment(store.getRecruitment());
			view.addObject("store", store);
			view.addObject("recruitmentSelect", recruitmentSelect);
		}
		view.setViewName("/competence/edit-recruitment-store");
		return view;
	}
	
	/**
	 * 进入编辑店铺状态页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "store/{id}/status", method = RequestMethod.GET)
	public ModelAndView editStoreStatus(@PathVariable("id") Integer id) {
		Store store = storeBiz.findById(id);
		if (store != null) {
			Map<Integer, String[]> statusSelect = storeBiz.fetchSelectStatus(store.getStatus());
			view.addObject("store", store);
			view.addObject("statusSelect", statusSelect);
		}
		view.setViewName("/competence/edit-status-store");
		return view;
	}
	
	/**
	 * 店铺搜索
	 * @param search
	 * @return
	 */
	@RequestMapping(value = "/phone/search", params = {"s", "page", "size"}, method = RequestMethod.GET)
	public ModelAndView search(@RequestParam("s") String search, @RequestParam("schoolId") Integer schoolId, @RequestParam("page") Integer page, @RequestParam("size") Integer size){
		List<Store> storesList = storeBiz.search(search, schoolId, page, size);
		view.addObject("storesList", storesList);
		view.setViewName("store-list");
		return view;
	}
	
	/**
	 * 根据学校id + 状态查询优惠
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "phone/{id}",params = { "page", "size", "storeName" }, method = RequestMethod.GET)
	public ModelAndView prefrentialStory(@PathVariable(value = "id") Integer id, @RequestParam("page") int page, @RequestParam("size") int size, @RequestParam("storeName") String storeName) {
		List<Store> storesList = storeBiz.findStoreList(id, SortStatuseEnum.STATUS_ONE.getStatus(), page, size, storeName);
		view.addObject("storesList", storesList);
		view.addObject("schoolId", id);
		view.setViewName("/youHui-lieBiao");
		return view;
	}
	
	/**
	 * 优惠多多，安全多多模块
	 * http://127.0.0.1:8001/store?p1=reviewScores_ge_0&p2=distributionCost_eq_0&page=50&size=1&sort=desc&sortName=updateDate
	 * 50&size=1
	 * 
	 * @return
	 */
	@RequestMapping(value = "store", params = { "p1", "page", "size", "sort" }, method = RequestMethod.GET)
	public ModelAndView youHuiStore(@RequestParam("p1") String p1, @RequestParam(value="p2", required=false) String p2, 
			@RequestParam("page") int page, @RequestParam("size") int size, @RequestParam("sort") String sort, @RequestParam("sortName") String sortName) {
		// 利用一个值标识对应的优惠 根据对应的值获取相应的查询条件
		List<Store> storesList = storeBiz.findStoreDuoTiaoJian(p1, p2, page, size, sort, sortName);
		System.out.println("---------size:" + storesList.size());
		view.addObject("storesList", storesList);
		view.setViewName("/youHui-lieBiao");
		return view;
	}
	
	

	/**
	 * 商店 列表页面
	 * 
	 * @param page
	 * @param size
	 * @param sea
	 * @param sort
	 * @return
	 */
	@RequestMapping(value = "store", params = { "page", "size" }, method = RequestMethod.GET)
	public ModelAndView store(@RequestParam("page") int page, @RequestParam("size") int size,
			@RequestParam(value = "sea", required = false) String sea,
			@RequestParam(value = "sort", required = false) String sort) {
		List<Store> storesList = storeBiz.findStoreList(page, size);
		view.addObject("storesList", storesList);
		view.addObject("page", ((StoreBizImpl) storeBiz).getPage());
		view.addObject("showPage", ((StoreBizImpl) storeBiz).getShowPage());
		view.setViewName("/competence/store");
		return view;
	}

	/**
	 * 删除商品信息
	 * 
	 * @param id
	 *            学校对应ID
	 * @return
	 */
	@RequestMapping(value = "store/{id}", method = RequestMethod.DELETE)
	public String store(@PathVariable(value = "id") Integer id) {
		storeBiz.deleteStore(id);
		return "redirect:/store?page=1&size=25";
	}
}
