package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.IArtist;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		   //get SessionFactory
		SessionFactory factory=HibernateUtil.getSessionFactory();
         Session ses=HibernateUtil.getSession();
        
         try(factory;ses){
              IArtist arts=ses.load(IArtist.class, 2335);
              //System.out.println(arts);
                 }//try
         catch(HibernateException he){
        	 System.out.println("Problem in Loading record/object");
        	   he.printStackTrace();
         }
         catch(Exception e){
        	 e.printStackTrace();
         }
         
	}//class
}//lcass
