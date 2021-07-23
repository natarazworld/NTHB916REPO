package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class L1CacheUpdateObjectTest {

	public static void main(String[] args) {
		//get SessionFactory
				SessionFactory factory=HibernateUtil.getSessionFactory();
				//get Session
				Session ses=HibernateUtil.getSession();
				Transaction tx=null;
				try(factory;ses){
					 //Load object
					  Product p=ses.get(Product.class,9045);  //collects from DB puts in L1 cache and gives to App
					  if(p==null)
						  System.out.println("record not found");
					  else {
						  tx=ses.beginTransaction();
						     p.setPrice(5678.0);  //modification1 reflects to L1 cache obj
						     p.setQty(56.0);  //modification2  reflects to L1 cache obj
						   tx.commit();  // Generates single Update SQL query reflecting the both moidifications.
						   System.out.println("record updated");
					  }
				}//try
				catch(HibernateException he) {
					if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly())
						  tx.rollback();
		               he.printStackTrace();			
				}
	}
}
