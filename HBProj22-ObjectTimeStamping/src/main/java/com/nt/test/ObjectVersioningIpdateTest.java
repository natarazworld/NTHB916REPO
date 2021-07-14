package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;

import com.nt.entity.MobilePhoneUser;
import com.nt.utility.HibernateUtil;

public class ObjectVersioningIpdateTest {

	public static void main(String[] args) {
		//create SessionFactory ,Session objs
		 SessionFactory factory=HibernateUtil.getSessionFactory();
		 Session ses=HibernateUtil.getSession();
		 Transaction tx=null;
		 try(factory;ses){
			 //begin Tx
			 tx=ses.beginTransaction();
			 //Load  object
			 MobilePhoneUser user=ses.get(MobilePhoneUser.class, 1L);
		 if(user!=null) {
				//update object
			     user.setCircle("UP");
				 ses.update(user);
			 //commit Tx
			 tx.commit();
			 System.out.println("Object is Lastly updated at ::"+user.getLastUpdated());
		 }
		 else {
			 System.out.println("Object not  found for updation");
		 }
			
		 }
		 catch(HibernateException he){
			 he.printStackTrace();
			 if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly())
				   tx.rollback();
			
		 }

	}//main
}//class
