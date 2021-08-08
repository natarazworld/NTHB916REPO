package com.nt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class HQLSelectTest1 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session ses = factory.openSession();
		try (factory; ses) {
			/*	//prepare Query object
				Query query=ses.createQuery("from Actor where  actorId>=?2 and  actorId<=?4");
				//set parameter values
				query.setParameter(2, 1000);
				query.setParameter(4, 2000);
				//execute the Query
				List<Actor> list=query.getResultList();
				//process the  Result
				list.forEach(actor->{
					System.out.println(actor);
				});*/
			
			/*	//prepare Query object
				Query query=ses.createQuery("from Actor where  actorId>=?1 and  actorId<=?2");
				//set parameter values
				
				query.setParameter(1, 1000);
				query.setParameter(2, 2000);
				//execute the Query
				List<Actor> list=query.getResultList();
				//process the  Result
				list.forEach(actor->{
					System.out.println(actor);
				});*/
			
			/*//prepare Query object
			Query query=ses.createQuery("FROM Actor WHERE  actorId=(SELECT max(actorId) FROM Actor)");
			//execute the Query
			List<Actor> list=query.getResultList();
			//process the  Result
			list.forEach(actor->{
				System.out.println(actor);
			});*/
			
			
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}

	}//main

}//class
