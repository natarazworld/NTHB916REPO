package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.PrgmrProjId;
import com.nt.entity.ProgrammersProjectsInfo;
import com.nt.utility.HibernateUtil;

public class ComppositeIdLoadObjectTest {

	public static void main(String[] args) {
		//get SessionFactory
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		try(factory;ses) {
			// prpare Composite id value
			PrgmrProjId id=new PrgmrProjId(101, 1001);
			//Load  obj
			 ProgrammersProjectsInfo info=ses.get(ProgrammersProjectsInfo.class, id);
			 if(info==null)
				 System.out.println("rcord not found");
			 else 
				 System.out.println(info);
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}

	}//main
}//class
