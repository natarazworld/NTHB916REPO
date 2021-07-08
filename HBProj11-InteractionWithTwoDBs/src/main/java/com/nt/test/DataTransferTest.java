//DataTransferTest.java
package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil_MySQL;
import com.nt.utility.HibernateUtil_Oracle;

public class DataTransferTest {

	public static void main(String[] args) {
	   //get SessionFactory,Session objs for oracle
		 SessionFactory oraFactory=HibernateUtil_Oracle.getSessionFactory();
		 Session oraSes=HibernateUtil_Oracle.getSession();
		//get SessionFactory,Session objs for mysql
		 SessionFactory mysqlFactory=HibernateUtil_MySQL.getSessionFactory();
		 Session mysqlSes=HibernateUtil_MySQL.getSession();
		 Transaction tx=null;
		 try(oraFactory;oraSes;mysqlFactory;mysqlSes){
			   //Load object from oralce
			 Product prod=oraSes.get(Product.class,2);
			 if(prod!=null) {
			 //begin Tx
			   tx=mysqlSes.beginTransaction();
			             mysqlSes.save(prod);
		          tx.commit();
		          System.out.println("Product is transferred");
			 }//if
			 else {
				 System.out.println("Product is not available to transfer");
			 }
		 }//try
		 catch(HibernateException he) {
			 if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()==true) {
				 tx.rollback();
				 System.out.println("Problem in Data Transfer");
			 }
		 }

	}//main
}//class
