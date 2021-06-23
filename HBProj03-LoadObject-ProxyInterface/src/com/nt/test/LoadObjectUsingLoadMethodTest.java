package com.nt.test;


import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.IProd;
import com.nt.entity.Product;

public class LoadObjectUsingLoadMethodTest {

	public static void main(String[] args) {
	    // activate HB fgramework
		Configuration cfg=new Configuration();
		//specify hibernate cfg file name and location
		cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//Create HB SessionFactory object
		SessionFactory factory=cfg.buildSessionFactory();
		//create SEssion object
		Session ses=factory.openSession();
		try {
			  //Load object (ses.get(-,-))
			 IProd proxy=ses.load(Product.class,9045);
			System.out.println(proxy.getClass()+"  "+proxy.getClass().getSuperclass()+"  "+Arrays.toString(proxy.getClass().getInterfaces()));
			 System.out.println("1");
				 System.out.println("record is ::"+proxy);
		}
		catch(HibernateException he) {
			System.out.println("object/record not found");
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//perform Tx Mgmt
			 //close  HB objects
			 ses.close();
			 factory.close();
		}//finally */

	}//main
}//class
