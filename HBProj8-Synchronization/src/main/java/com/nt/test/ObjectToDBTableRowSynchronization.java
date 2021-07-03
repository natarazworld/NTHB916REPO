//SaveOrUpdateObjectTest1 .java
package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class ObjectToDBTableRowSynchronization{

	public static void main(String[] args) {
	   //get SessionFactory obj
		 SessionFactory factory=HibernateUtil.getSessionFactory();
		 //get Session obj
		 Session ses=HibernateUtil.getSession();
		 Transaction tx=null;
		 try(factory;ses){
			 //begin Tx
			   tx=ses.beginTransaction();
			         //Load the object
			      Product prod=ses.get(Product.class, 9046);
			        //modify the object
			         prod.setPrice(40000.0);
			          tx.commit();
			          System.out.println("Object is  updated");
		 }//try
		 catch(HibernateException he) {
			 if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()==true) {
				 tx.rollback();
				 System.out.println("Object is not updated ");
			 }
		 }

	}//main
}//class
