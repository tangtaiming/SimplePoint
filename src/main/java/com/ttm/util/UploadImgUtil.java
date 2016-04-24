package com.ttm.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * 
 * <p>
 * 介绍：上传图片
 * </p>
 * 
 * @author 唐太明
 * @date 2016年4月19日 下午10:47:09
 * @version 1.0
 */
public class UploadImgUtil {
	
	private static Logger log = Logger.getLogger(UploadImgUtil.class);
	
	private String pathImg;
	
	private boolean isImg;
	
	public UploadImgUtil() {
		pathImg = "";
		isImg = true;
	}

	/**
	 * 上传文件
	 * @param multiRequest
	 * @param isImg
	 * @param pathImg
	 */
	public void uploadImg(MultipartHttpServletRequest multiRequest) {
		// 开始时间
		long startTime = System.currentTimeMillis();
		Iterator<String> iterator = multiRequest.getFileNames();
		while (iterator.hasNext()) {
			// 遍历所有文件
			MultipartFile file = multiRequest.getFile(iterator.next().toString());
			if (file != null) {
				String of = file.getOriginalFilename();
				if (StringUtils.isEmpty(of)) {
					log.info("文件为空.");
				} else {
					SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
					String datePath = format.format(new Date());
					//获取图片文件上传目录
					String dir = multiRequest.getServletContext().getRealPath("/images/upload");
					// 获取文件名称
					pathImg = datePath + "_" + of;
					log.info("getServletContext(): " + multiRequest.getServletContext().getRealPath("/"));
					String path = dir + "/" + pathImg;
					
					// 上传
					try {
						file.transferTo(new File(path));
						log.info("上传图片 " + pathImg + "成功,上传至" + dir + "目录下");
					} catch (IllegalStateException e) {
						e.printStackTrace();
						isImg = false;
					} catch (IOException e) {
						e.printStackTrace();
						isImg = false;
					}
				}
			}
		}
		// 结束时间
		long endTime = System.currentTimeMillis();
		System.out.println("运行时间:" + String.valueOf(endTime - startTime));
	}

	public String getPathImg() {
		return pathImg;
	}

	public void setPathImg(String pathImg) {
		this.pathImg = pathImg;
	}

	public boolean isImg() {
		return isImg;
	}

	public void setImg(boolean isImg) {
		this.isImg = isImg;
	}

}
