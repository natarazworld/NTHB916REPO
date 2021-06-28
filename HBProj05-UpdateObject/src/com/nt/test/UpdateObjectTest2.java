package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class UpdateObjectTest2 {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(factory;ses){
			//Load object
			Product p=ses.get(Product.class, 9023);
		    if(p==null) {
		      System.out.println("record not found");
		    }
		    else {
			   //Begin Tx
			     tx=ses.beginTransaction();
			      p.setPrice(930.0);
			       ses.update(p);
                   tx.commit();
                   System.out.println("Object found and partiall updated");
		    }
                   
		}//try
		catch(HibernateException he) {
			if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()==true)
				tx.rollback();
		   System.out.println("Object is not updated");
			he.printStackTrace();
		}
		catch(Exception e) {
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()==true)
				tx.rollback();
			System.out.println("Object is not updated");
			e.printStackTrace();
		}

	}//main
}//class
