package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class SaveOjectTest {

	public static void main(String[] args) {
		try {
		//get SessionFactory
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get Session
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
			 tx=ses.beginTransaction();
                  Product p=new Product();
                   p.setPname("sofa5");
                  p.setPrice(5455.0);p.setQty(55.77);
                  p.setStatus("avaiable");
			      String idVal=(String)ses.save(p); 
			       System.out.println("generated id value ::"+idVal);
			      tx.commit(); 
		}//try
		catch(HibernateException he) {
              he.printStackTrace();			
		}
	}
}
