package com.nt.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class LoadObjectUsingGetMethodTest {

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
			 Product prod=ses.get(Product.class,1001);
			 if(prod==null) {
				 System.out.println("record not found");
			 }
			 else {
				 System.out.println("record not found and it is"+prod.getPid()+"  "+prod.getPname()+"  "+prod.getPrice()+" "+prod.getQty()+" "+prod.getStatus());
			 }
		}
		catch(HibernateException he) {
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
