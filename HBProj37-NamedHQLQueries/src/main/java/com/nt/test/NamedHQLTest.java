package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class NamedHQLTest {

	public static void main(String[] args) {
		 SessionFactory factory=HibernateUtil.getSessionFactory();
		   Session ses=HibernateUtil.getSession();
		   try(factory;ses){
			   //get Access the Named HQL query
			    Query query=ses.getNamedQuery("HQL_GET_ACTORS_BY_ACTORID_RANGE");
			    //set query param values
			    query.setParameter("min", 1000);
			    query.setParameter("max",10000);
			    //execute the query
               List<Actor> list=query.getResultList();
               list.forEach(actor->{
            	   System.out.println(actor);
               });
		   }//try
		   catch(HibernateException he) {
				     System.out.println("problem in record insertion");
			   }
		   }//main
	}//class
