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
			 MobilePhoneUser user=new MobilePhoneUser(555998888L,true,"telangana","dil jale");
			 user.setRegNo(554353L);
				//save object
					 ses.save(user);
			 //commi tx
			 tx.commit();
			 System.out.println("Object is saved at::"+user.getDoj()+"  no.of modifications::"+user.getUpdationCount());
		 }
		 catch(HibernateException he){
			 he.printStackTrace();
			 if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly())
				   tx.rollback();
			 
		 }

	}//main
}//class
