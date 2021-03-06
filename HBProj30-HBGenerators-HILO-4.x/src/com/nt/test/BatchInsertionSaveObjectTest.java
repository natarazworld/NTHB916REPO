package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class BatchInsertionSaveObjectTest {

	public static void main(String[] args) {
		
		//get SessionFactory
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get Session
		Session ses=HibernateUtil.getSession();
		
		Transaction tx=null;
		try{
			 tx=ses.beginTransaction();
			for(int i=1;i<=10;++i) {
			
                  Product p=new Product();
                   p.setPname("sofa7");
                  p.setPrice(5455.0);p.setQty(55.77);
                  p.setStatus("avaiable");
                  int idVal=(Integer)ses.save(p);
			       System.out.println("generated id value ::"+idVal);
			}
		       tx.commit();
 		}//try
		catch(HibernateException he) {
              he.printStackTrace();			
		}
		finally {
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}
}
