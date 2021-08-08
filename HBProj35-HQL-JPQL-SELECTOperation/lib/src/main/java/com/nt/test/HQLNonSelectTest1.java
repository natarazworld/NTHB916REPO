package com.nt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class HQLNonSelectTest1 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session ses = factory.openSession();
		Transaction tx=null;
		try (factory; ses) {
			/*// Begin Tx
			tx=ses.beginTransaction();
			   //prepare Query object
			 Query query=ses.createQuery("update Actor  set mobileNo=?1 where actorName=?2");
			 //set parameter values
			 query.setParameter(1,54353453453L);
			 query.setParameter(2,"sharukh");
			 //execute the query
			 int count=query.executeUpdate();
			tx.commit();
			 System.out.println("no.of records are that are effeted ::"+count);*/
			
			tx=ses.beginTransaction();
			   //prepare Query object
			 Query query=ses.createQuery("DELETE FROM Actor WHERE actorAddrs in(:addrs1,:addrs2)");
			 //set parameter values
			 query.setParameter("addrs1","hyd");
			 query.setParameter("addrs2","delhi");
			 //execute the query
			 int count=query.executeUpdate();
			tx.commit();
			 System.out.println("no.of records are that are effeted ::"+count);
			
			
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				tx.rollback();
			}
		}

	}//main

}//class
