package com.nt.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class SaveObjectTest1 {

	public static void main(String[] args) {
	    // activate HB fgramework
		Configuration cfg=new Configuration();
		//specify hibernate cfg file name and location
		cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//Create HB SessionFactory object
		SessionFactory factory=cfg.buildSessionFactory();
		//create SEssion object
		Session ses=factory.openSession();
		//prpeare  Entity class obj having data
		Product p=new Product();
		p.setPid(9021); p.setPname("table");
		p.setPrice(9000.55); p.setQty(10.0); p.setStatus("avaiable");
		//save object
			  ses.save(p);
			  //flus the session
			  ses.flush();
			  System.out.println("Object is saved (record is inserted)");
			 
			 //close  HB objects
			 ses.close();
			 factory.close();

	}//main
}//class
