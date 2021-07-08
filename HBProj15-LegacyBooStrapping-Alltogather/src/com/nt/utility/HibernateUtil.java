package com.nt.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	static {
		try {
		//Actiate  hibernate
		Configuration cfg=new Configuration();
		//declarative approach
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		cfg.addResource("com/nt/entity/Product.hbm.xml");
		//create ServiceRegistryBuilder
		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
		//create Servicer registry
		StandardServiceRegistry registry=builder.applySettings(cfg.getProperties()).build();
		//build SessionFactory using registry
		 factory=cfg.buildSessionFactory(registry);
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//static
	
	 public  static  SessionFactory getSessionFactory() {
             return factory;
	 }
	 public  static   Session  getSession() {
		 Session ses=null;
		   if(factory!=null)
			   ses=factory.openSession();
		   return ses;
	 }
	 
	 public static void closeSession(Session ses) {
		  if(ses!=null)
			  ses.close();
	 }
	 
	 public static void closeSessionFactory() {
		  if(factory!=null)
			  factory.close();
	 }


}//class
