package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class DeleteObjectTest {

	public static void main(String[] args) {
		//get SEssionFactory object
		 SessionFactory factory=HibernateUtil.getSessionFactory();
		 Session ses=HibernateUtil.getSession();
		 Transaction tx=null;
		 try(factory;ses){
			 //prepare object
			  Product p=new Product();
			  p.setPid(9045);
			  //begin Tx
			    tx=ses.beginTransaction();
			       ses.delete(p);
               tx.commit();
               System.out.println("Object deleted");
		 }
		 catch(HibernateException he) {
			 if(tx!=null  && tx.getStatus()!=null && tx.getRollbackOnly() )
				 tx.rollback();
			 System.out.println("object not deleted");
		 }
	}//main
}//class
