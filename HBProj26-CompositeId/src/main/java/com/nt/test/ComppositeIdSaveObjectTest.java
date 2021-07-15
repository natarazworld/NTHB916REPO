package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.PrgmrProjId;
import com.nt.entity.ProgrammersProjectsInfo;
import com.nt.utility.HibernateUtil;

public class ComppositeIdSaveObjectTest {

	public static void main(String[] args) {
		//get SessionFactory
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(factory;ses) {
			tx=ses.beginTransaction();
			// prpare Composite id value
			PrgmrProjId id=new PrgmrProjId(101, 1001);
			ProgrammersProjectsInfo info=new ProgrammersProjectsInfo(id, "rajesh", "openFx",10);
			//save obj
			PrgmrProjId idVal=(PrgmrProjId) ses.save(info);
			tx.commit();
			System.out.println("Object is saved having composite id ::"+idVal);
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}

	}//main
}//class
