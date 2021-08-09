package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.utility.HibernateUtil;

public class HQLInsertTest {

	public static void main(String[] args) {
		
	   SessionFactory factory=HibernateUtil.getSessionFactory();
	   Session ses=HibernateUtil.getSession();
	   Transaction tx=null;
	   try(factory;ses){
		   tx=ses.beginTransaction();
		   //prepare and execute HQL Insert
		    Query query=ses.createQuery("INSERT INTO MumbaiActor(actorId,actorName,actorAddrs,mobileNo) SELECT a.actorId,a.actorName,a.actorAddrs,a.mobileNo FROM Actor  as a WHERE a.actorAddrs=?1");
		    query.setParameter(1, "mumbai");
		    int count=query.executeUpdate();
		    tx.commit();
		    System.out.println("No.of records that are effected::"+count);
		   
	   }//try
	   catch(HibernateException he) {
		   if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
			     tx.rollback();
			     System.out.println("problem in record insertion");
		   }
	   }

	}

}
