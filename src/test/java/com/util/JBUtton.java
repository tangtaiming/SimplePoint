package com.util;

import java.lang.reflect.Field;

import javax.swing.JFrame;

import org.apache.commons.lang.StringUtils;

import com.ttm.biz.StoreBiz;
import com.ttm.biz.impl.StoreBizImpl;
import com.ttm.orm.MeiShi;
import com.ttm.orm.Store;
import com.ttm.util.Dumper;

public class JBUtton extends JFrame {

	public static void main(String[] args) {
		String s = "4.0";
		
//		System.out.println(s.contains("."));
		
		StoreBiz sb = new StoreBizImpl();
		String p1 = "distributionCost_eq_0";
		String p2 = "sendThePrice_eq_0";
		
		Dumper.dump(StringUtils.split(p1, "_"));
		Integer page = 1;
		Integer size = 120;
		String sort = "desc";
		String sortName = "updateDate";
		Dumper.dump(sb.findStoreDuoTiaoJian(p1, p2, page, size, sort, sortName).size());
	}

	public static void setAllComponentsName(Object f) {
		// 获取f对象对应类中的所有属性域
		Field[] fields = f.getClass().getDeclaredFields();
		for (int i = 0, len = fields.length; i < len; i++) {
			// 对于每个属性，获取属性名
			String varName = fields[i].getName();
			try {
				// 获取原来的访问控制权限
				boolean accessFlag = fields[i].isAccessible();
				// 修改访问控制权限
				fields[i].setAccessible(true);
				// 获取在对象f中属性fields[i]对应的对象中的变量
				Object o = fields[i].get(f);
				System.out.println("传入的对象中包含一个如下的变量：" + varName + " = " + o);
				// 恢复访问控制权限
				fields[i].setAccessible(accessFlag);
			} catch (IllegalArgumentException ex) {
				ex.printStackTrace();
			} catch (IllegalAccessException ex) {
				ex.printStackTrace();
			}
		}
	}

}
