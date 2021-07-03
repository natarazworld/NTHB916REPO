//SaveOrUpdateObjectTest1 .java
package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class DBTableRowToObjectSynchronization{

	public static void main(String[] args) {
	   //get SessionFactory obj
		 SessionFactory factory=HibernateUtil.getSessionFactory();
		 //get Session obj
		 Session ses=HibernateUtil.getSession();
		 Transaction tx=null;
		 try(factory;ses){
			         //Load the object
			      Product prod=ses.get(Product.class, 9046);
			      System.out.println(prod);
			      System.out.println("============================");
			      System.out.println("Modify 9046 record from the db table during the sleep time");
			      Thread.sleep(40000); 
                  ses.refresh(prod);
                  System.out.println(prod);
			    
		 }//try
		 catch(HibernateException he) {
			 he.printStackTrace();
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }

	}//main
}//class
