package com.nt.test;

import java.util.Timer;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.Product;
import com.nt.scheduling.L1CacheEmptyingService;
import com.nt.utility.HibernateUtil;

public class L1CacheTimerSelectTest {

	public static void main(String[] args) {
		//get SessionFactory
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get Session
		Session ses=HibernateUtil.getSession();
		Timer timer =new Timer();
		timer.schedule(new L1CacheEmptyingService(ses), 1000,2000);
		try(factory;ses){
			 //Load object
			  Product p=ses.load(Product.class,9045);  //collects from DB puts in L1 cache and gives to App
			  System.out.println(p);
			  Thread.sleep(5000);
			  System.out.println("---------------------");
			  Product p1=ses.load(Product.class,9045);  //collects from  L1 cache and gives to App
			  System.out.println(p1);
			  System.out.println("---------------------");
			  Thread.sleep(2000);
			  Product p2=ses.load(Product.class,9045); //collects from DB puts in L1 cache and gives to App
			  System.out.println(p2);
			  
		}//try
		catch(HibernateException he) {
              he.printStackTrace();			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
