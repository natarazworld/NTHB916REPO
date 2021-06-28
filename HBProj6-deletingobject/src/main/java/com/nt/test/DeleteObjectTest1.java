package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class DeleteObjectTest1 {

	public static void main(String[] args) {
		//get SEssionFactory object
		 SessionFactory factory=HibernateUtil.getSessionFactory();
		 Session ses=HibernateUtil.getSession();
		 Transaction tx=null;
		 try(factory;ses){
			 //Load object
			 Product prod=ses.get(Product.class, 9046);
			 if(prod==null)
				 System.out.println("record not found to delete");
			 else {
			  //begin Tx
			    tx=ses.beginTransaction();
			       ses.delete(prod);
               tx.commit();
               System.out.println("Object deleted");
			 }
		 }
		 catch(HibernateException he) {
			 if(tx!=null  && tx.getStatus()!=null && tx.getRollbackOnly() )
				 tx.rollback();
			 System.out.println("object not deleted");
		 }
	}//main
}//class
