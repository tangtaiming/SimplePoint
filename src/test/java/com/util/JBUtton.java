package com.util;

import javax.swing.JFrame;

public class JBUtton extends JFrame  {

	public static void main(String[] args) {
		JBUtton b = new JBUtton();
		b.add(new JBUtton());
	}
	
	public JBUtton(String str) {
		super(str);
	} 
	
	public JBUtton() {
		
	}
}
