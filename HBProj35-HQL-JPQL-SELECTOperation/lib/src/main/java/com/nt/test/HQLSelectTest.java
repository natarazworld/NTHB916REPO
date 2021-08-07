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
			/*//prepare Query Object  (HQL Select Entity Query)
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
			
			/*	//prepare Query Object
				 Query  query=ses.createQuery("from Actor");
				 //execute the query
				 Iterator<Actor> it=query.iterate();
				 //process the ResultSet
				 while(it.hasNext()) {
					 Actor actor=it.next();
					 System.out.println(actor);
					// System.out.println(actor.getActorId()+"  "+actor.getActorName()+"  "+actor.getActorAddrs()+" "+actor.getMobileNo());
				 }//while
			*/
			
			/*	// HQL Select Query (Entity query-Selecting allo col values of DB table)
				Query query=ses.createQuery("from Actor where  actorAddrs=?1");
				query.setParameter(1, "hyd");
				List<Actor> list=query.getResultList();
				list.forEach(actor->{
					System.out.println(actor);
				});*/
			
			/*			// HQL Select Query (scalar query-Getting specific multiple col values of db table)
						Query query=ses.createQuery("SELECT actorId,actorName from Actor where  actorAddrs=?1");
						query.setParameter(1, "hyd");
						List<Object[]> list=query.getResultList();
						list.forEach(row->{
							for(Object val:row)
								System.out.print(val+" ");
							System.out.println();
						});
			*/			
			
			/*	// HQL Select Query (scalar query-Getting specific single col value of db table)
				Query query=ses.createQuery("SELECT actorName from Actor where  actorAddrs=?1");
				query.setParameter(1, "hyd");
				List<String> list=query.getResultList();
				list.forEach(name->{
					System.out.println(name);
				});*/
			
			/*// HQL Select Query using iterate() method (scalar query-Getting specific single col value of db table)
			Query query=ses.createQuery("SELECT actorId,actorName from Actor where  actorAddrs=?1");
			query.setParameter(1, "hyd");
			Iterator<Object[]> it=query.iterate();
			while(it.hasNext()) {
				Object row[]=it.next();
				for(Object val:row)
					System.out.print(val+"   ");
				System.out.println();
			}
			*/
			
			/*// HQL Select Query using getSingleResult() method (Entity query giving 0 or 1 record)
			Query query=ses.createQuery(" FROM Actor where  actorId=?1");
			query.setParameter(1,456);
			Actor actor=(Actor) query.getSingleResult();
			if(actor==null)
			 System.out.println("record not found");
			else {
				System.out.println("Record found");
			    System.out.println(actor);				
			}*/
			
			/*// HQL Select Query using getSingleResult() method (Scalar query(mutliple cols)  giving 0 or 1 record)
						Query query=ses.createQuery(" SELECT actorId,actorName FROM Actor where  actorId=?1");
						query.setParameter(1,456);
						Object[] row=(Object[]) query.getSingleResult();
						if(row==null)
						 System.out.println("record not found");
						else {
							System.out.println("Record found");
						    System.out.println(row[0]+"   "+row[1]);				
						}*/
			
			/*// HQL Select Query using getSingleResult() method (Scalar query(single col) giving 0 or 1 record)
			Query query=ses.createQuery(" SELECT actorName FROM Actor where  actorId=?1");
			query.setParameter(1,456);
			String name=(String)query.getSingleResult();
			if(name==null)
			 System.out.println("record not found");
			else {
				System.out.println("Record found");
			    System.out.println("Actor name::"+name);				
			}*/
			
			/*// HQL Select Query using getSingleResult() method (Scalar query(aggragate function))
				Query query=ses.createQuery(" SELECT count(*) FROM Actor");
				Long count=(Long)query.getSingleResult();
				System.out.println("recrods count::"+count);*/
				
				// HQL Select Query using getSingleResult() method (Scalar query(with multiple aggragate functions))
				Query query=ses.createQuery(" SELECT count(*),avg(actorId),min(actorId),max(actorId),sum(actorId) FROM Actor");
				Object row[]=(Object[])query.getSingleResult();
				System.out.println("recrods count::"+row[0]);
				System.out.println("avg value of  actorId::"+row[1]);
				System.out.println("min value of  actorId::"+row[2]);
				System.out.println("max value of  actorId::"+row[3]);
				System.out.println("sum value of  actorId::"+row[4]);
			
			
			
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}

	}//main

}//class
