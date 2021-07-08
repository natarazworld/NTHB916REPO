package com.nt.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;
import com.nt.utility.HibernateUtil1;


public class LoadObjectUsingGetMethodTest {

	public static void main(String[] args) {
	    SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil1.getSession();
		try {
			  //Load object (ses.get(-,-))
			 Product prod=ses.get(Product.class,1);
			 if(prod==null) {
				 System.out.println("record not found");
			 }
			 else {
				 System.out.println("record not found and it is"+prod.getPid()+"  "+prod.getPname()+"  "+prod.getPrice()+" "+prod.getQty()+" "+prod.getStatus());
			 }
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//perform Tx Mgmt
			 //close  HB objects
			HibernateUtil1.closeSession(ses);
			HibernateUtil1.closeSessionFactory();
		}//finally */

	}//main
}//class
