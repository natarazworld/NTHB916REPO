package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class UpdateObjectTest1 {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(factory;ses){
				//prepre object 
			   Product p=new Product();
			   p.setPid(9067); p.setPname("FaceCream");
			   p.setPrice(920.0); p.setQty(4.0); p.setStatus("NotAvailble");
			   //Begin Tx
			     tx=ses.beginTransaction();
			       ses.update(p);
                   tx.commit();
                   System.out.println("Object updated");
                   
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
