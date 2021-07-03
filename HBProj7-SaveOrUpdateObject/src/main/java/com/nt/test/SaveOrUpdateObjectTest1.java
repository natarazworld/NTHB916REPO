//SaveOrUpdateObjectTest1 .java
package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class SaveOrUpdateObjectTest1 {

	public static void main(String[] args) {
	   //get SessionFactory obj
		 SessionFactory factory=HibernateUtil.getSessionFactory();
		 //get Session obj
		 Session ses=HibernateUtil.getSession();
		 Transaction tx=null;
		 try(factory;ses){
			 //begin Tx
			   tx=ses.beginTransaction();
			      //prepare object
			        Product prod=new Product();
			          prod.setPid(9050);
			          prod.setPname("reclainer1");
			          prod.setPrice(150000.0);
			       //   prod.setQty(30.0);
			         // prod.setStatus("not avaiable");
			          //save or update object
			          ses.saveOrUpdate(prod);
			          tx.commit();
			          System.out.println("Object is saved or updated");
		 }//try
		 catch(HibernateException he) {
			 if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()==true) {
				 tx.rollback();
				 System.out.println("Problem is  saving or updating object");
			 }
		 }

	}//main
}//class
