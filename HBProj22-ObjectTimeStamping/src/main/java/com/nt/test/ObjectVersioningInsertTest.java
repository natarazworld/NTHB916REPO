package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;

import com.nt.entity.MobilePhoneUser;
import com.nt.utility.HibernateUtil;

public class ObjectVersioningInsertTest {

	public static void main(String[] args) {
		//create SessionFactory ,Session objs
		 SessionFactory factory=HibernateUtil.getSessionFactory();
		 Session ses=HibernateUtil.getSession();
		 Transaction tx=null;
		 try(factory;ses){
			 //begin Tx
			 tx=ses.beginTransaction();
			  //prepare object
			 MobilePhoneUser user=new MobilePhoneUser(15998888L,true,"telangana","dil vil");
				//save object
					 ses.save(user);
			 //commi tx
			 tx.commit();
			 System.out.println("Object is saved at::"+user.getLastUpdated());
		 }
		 catch(HibernateException he){
			 if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly())
				   tx.rollback();
			 he.printStackTrace();
		 }

	}//main
}//class
