package com.nt.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

import javassist.tools.rmi.ObjectNotFoundException;

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
			 Product prod=ses.load(Product.class,9045);
				// System.out.println("record is ::"+prod);
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
