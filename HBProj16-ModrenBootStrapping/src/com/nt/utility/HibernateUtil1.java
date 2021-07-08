package com.nt.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.jdbc.dialect.spi.DialectResolver;

public class HibernateUtil1 {
	private static SessionFactory factory;
	static {
		try {
		//Actiate  hibernate
		Configuration cfg=new Configuration();
		//create ServiceRegistryBuilder
		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
		//create Servicer registry
		StandardServiceRegistry registry=builder.configure("com/nt/cfgs/hibernate.cfg.xml").build();
		System.out.println(registry.getParentServiceRegistry().getClass()+"  "+registry.getService(ConnectionProvider.class)+"  "+registry.getService(ClassLoaderService.class));
		System.out.println(registry.getService(DialectResolver.class));
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
