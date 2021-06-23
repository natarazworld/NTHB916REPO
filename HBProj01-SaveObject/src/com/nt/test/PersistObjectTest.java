package com.nt.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class PersistObjectTest {

	public static void main(String[] args) {
	    // activate HB fgramework
		Configuration cfg=new Configuration();
		System.out.println(cfg.getProperties());
		System.out.println("-------------------------");
		//specify hibernate cfg file name and location
		cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//cfg.configure();
		System.out.println(cfg.getProperties());
		//Create HB SessionFactory object
		SessionFactory factory=cfg.buildSessionFactory();
		System.out.println("session factory obj class name::"+factory.getClass());
		//create SEssion object
		Session ses=factory.openSession();
		System.out.println("session obj class name::"+ses.getClass());
		//prpeare  Entity class obj having data
		Product p=new Product();
		p.setPid(9057); p.setPname("table");
		p.setPrice(9000.55); p.setQty(10.0); 
		//save object
		Transaction tx=null;
		boolean flag=false;
		try {
			//begin Tx
			tx=ses.beginTransaction();  //internally calls con.setAutoCommit(false)
			  ses.persist(p);
     	     flag=true;
		}
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			//perform Tx Mgmt
			
			 if(flag) {
				 tx.commit();   //internally calls con.commit() method
				 System.out.println("Object is saved(Record inserted)");
			 }
			 else {
				tx.rollback();  //internally calls con.rollback() method
				 System.out.println("Object is  not saved(Record is not inserted)");
			 }
			 
			 //close  HB objects
			 ses.close();
			 factory.close();
		}//finally */

	}//main
}//class
