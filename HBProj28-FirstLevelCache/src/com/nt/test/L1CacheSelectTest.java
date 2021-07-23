package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class L1CacheSelectTest {

	public static void main(String[] args) {
		//get SessionFactory
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get Session
		Session ses=HibernateUtil.getSession();
		try(factory;ses){
			 //Load object
			  Product p=ses.load(Product.class,9045);  //collects from DB puts in L1 cache and gives to App
			  System.out.println(p);
			  System.out.println("---------------------");
			  Product p1=ses.load(Product.class,9045);  //collects from  L1 cache and gives to App
			  System.out.println(p1);
			  System.out.println("---------------------");
			  //ses.evict(p1);  //removes Product obj with 9045 id value from L1 cache
			  ses.clear();  // Removes all objects from L1 cache
			  Product p2=ses.load(Product.class,9045); //collects from DB puts in L1 cache and gives to App
			  System.out.println(p2);
			  
		}//try
		catch(HibernateException he) {
              he.printStackTrace();			
		}
	}
}
