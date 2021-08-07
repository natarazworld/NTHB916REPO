package com.nt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class HQLSelectTest {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session ses = factory.openSession();
		try (factory; ses) {
			/*//prepare Query Object
			 Query  query=ses.createQuery("from Actor");
			 //send and execute query
			 List<Actor> list=query.getResultList();
				 list.forEach(actor->{   //LAMDA
					 System.out.println(actor);
				 });
			 //list.forEach(System.out::println);  //LAMDA with method reference
			 //list.stream().forEach(System.out::println);  // LAMDA with stream api , method reference
			 for(Actor actor:list) {    // Enhanced for look
				 System.out.println(actor);
			 }*/
			
			//prepare Query Object
			 Query  query=ses.createQuery("from Actor");
			 //execute the query
			 Iterator<Actor> it=query.iterate();
			 //process the ResultSet
			 while(it.hasNext()) {
				 Actor actor=it.next();
				 System.out.println(actor);
				// System.out.println(actor.getActorId()+"  "+actor.getActorName()+"  "+actor.getActorAddrs()+" "+actor.getMobileNo());
			 }//while

		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}

	}//main

}//class
