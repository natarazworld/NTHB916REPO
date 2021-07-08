package com.nt.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
	  //create SEssionFactory ,Session objs
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=factory.openSession();
		Transaction tx=null;
		try(factory;ses){
		//prpeare  Entity class obj having data
		Product p=new Product();
		p.setPid(9021); p.setPname("chair");
		p.setPrice(8000.55);
		p.setQty(20.0); p.setStatus("avaiable"); 
		//begin Tx
			tx=ses.beginTransaction();  //internally calls con.setAutoCommit(false)
			//save object
			System.out.println(" is Session dirty :::"+ses.isDirty());
			  int idVal=(int)ses.save(p);
			  System.out.println(" is Session dirty :::"+ses.isDirty());
			  System.out.println("generated id value::"+idVal);
		       tx.commit();
		       System.out.println(" is Session dirty :::"+ses.isDirty());
		}
		catch(HibernateException he) {
		 if(tx!=null  && tx.getStatus()!=null && tx.getRollbackOnly())
			  tx.rollback();
		 he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//main
}//class
