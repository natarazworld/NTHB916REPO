package com.nt.utility;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	static {
		try {
		 //Load Properties file Info  to java.util.Properties class obj
			Properties props=new Properties();
			InputStream is=new FileInputStream("src/com/nt/commons/info.properties");
			//InputStream is=new FileInputStream("src/main/java/com/nt/commons/info.properties");  //maven/gradle
			props.load(is);
			
		//Actiate  hibernate
		Configuration cfg=new Configuration();
		cfg.setProperties(props);
		cfg.addFile("src/com/nt/entity/Product.hbm.xml");
		//build SessionFactory
		 factory=cfg.buildSessionFactory();
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
