package com.nt.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	static {
		try {
			// Configuration object
			Configuration cfg = new Configuration();
			cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
			// build SessionFactory
			factory = cfg.buildSessionFactory();
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// static
	
	  public static  SessionFactory   getSessionFactory() {
		  if(factory!=null)
		     return factory;
		  else
			  throw new RuntimeException("Invalid SessionFactory object creation ");
	  }
	  
	  public  static   Session   getSession() {
		  Session ses=null;
		   if(factory!=null)
			   ses=factory.openSession();
		   
		   return ses;
	  }
	  
	   public static   void  closeSession(Session ses) {
		   if(ses!=null)
			   ses.close();
	   }
	   
	   public static  void  closeSessionFactory() {
		    if(factory!=null)
		    	factory.close();
	   }

}
