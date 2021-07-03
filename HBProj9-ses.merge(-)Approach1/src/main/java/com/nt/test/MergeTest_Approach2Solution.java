//SaveOrUpdateObjectTest1 .java
package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class MergeTest_Approach2Solution {

	public static void main(String[] args) {
	   //get SessionFactory obj
		 SessionFactory factory=HibernateUtil.getSessionFactory();
		 //get Session obj
		 Session ses=HibernateUtil.getSession();
		 Transaction tx=null;
		 try(factory;ses){
			 //begin Tx
			   tx=ses.beginTransaction();
			       //Load Object
			       Product prod=ses.get(Product.class, 9046);
			       if(prod==null)
			    	   System.out.println("Object not found");
			       else {
			    	   System.out.println("object found::"+prod);
			    	   Product prod1=new Product();
			    	   prod1.setPname("green-grass");
			    	   prod1.setPrice(50000.0);
			    	   prod1.setPid(9046);
			    	   prod1.setQty(31.0);
			    	   prod1.setStatus("avaiable");
			    	   Product p1=(Product)ses.merge(prod1);
			    	   System.out.println(prod.hashCode()+"   "+prod1.hashCode()+"  "+p1.hashCode());
			          tx.commit();
			          System.out.println("Object is  updated");
			       }
		 }//try
		 catch(HibernateException he) {
			 he.printStackTrace();
			 if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()==true) {
				 tx.rollback();
				 System.out.println("Problem is  saving or updating object");
			 }
		 }

	}//main
}//class
