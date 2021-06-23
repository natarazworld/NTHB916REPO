package com.nt.core;

import java.util.Calendar;

public class TestApp {

	public static void main(String[] args) throws Exception {
		Class clazz1=Class.forName("java.util.Date");
		System.out.println("data of  clazz1 object"+clazz1);
		System.out.println("---------------------------");
		
		java.util.Calendar cal=Calendar.getInstance();
		Class clazz2=cal.getClass();
		System.out.println("data of  clazz2 object"+clazz2);
		System.out.println("---------------------------");
		
		Class clazz3=System.class;
		System.out.println("data of  clazz3 object"+clazz3);
		
		//creating object of loaded java class using java.lang.Class methods.
		Object obj=clazz1.newInstance();
		System.out.println(obj.getClass()+"  "+obj.toString());
		
		
	    

	}

}
