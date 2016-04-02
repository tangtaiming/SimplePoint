package com.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ParseHtml {

	public static void main(String[] args) {
		File file = new File("E://Project//eclipse//Geclipse//university-service//target//university-service//index.jsp");
		Document document = null;
		try {
			document = Jsoup.parse(file, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements h2 = document.getElementsByTag("h2");
		String html = "<span>1111111111111</span>";
		System.out.println(document.html());
		h2.append(html);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println(document.html());
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

//		char[] buffer = new char[32];
//		int hasRead = 0;
		
		//读取数据到 输入流
//		BufferedInputStream sb = new BufferedInputStream(System.in);
		
//		StringReader sr = new StringReader(document.html());
//		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^写入文件");
//		FileWriter fw = null;
//		try {
//			fw = new FileWriter(file);
//			while((hasRead = sr.read(buffer)) > 0) {
//				fw.write(buffer, 0, hasRead);
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			if (fw != null) {
//				try {
//					fw.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
	}
	
}
