package com.nt.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class LoadObjectUsingGetMethodTestTWR {
	
	public static void main(String[] args) {

		 
try(SessionFactory factory=HibernateUtil.getSessionFactory();
            Session ses=HibernateUtil.getSession(); ){
   			  //Load object (ses.get(-,-))
			 Product prod=ses.get(Product.class,9045);
			 if(prod!=null)
				 System.out.println("record not found and it is"+prod.getPid()+"  "+prod.getPname()+"  "+prod.getPrice()+" "+prod.getQty()+" "+prod.getStatus());
			 else
				 System.out.println("Record not found");
        }//try1
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//main
}//class
