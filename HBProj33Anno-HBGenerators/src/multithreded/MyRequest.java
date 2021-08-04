package multithreded;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class MyRequest implements Runnable {
	

	@Override
	public void run() {
		System.out.println("Thread name::"+Thread.currentThread().getName());
		try {
		if(Thread.currentThread().getName().equalsIgnoreCase("thread2"))
			   Thread.sleep(40000);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		Transaction tx=null;
		Session ses=HibernateUtil.getSession();
		Product p1=new Product();
		p1.setPname("sofa"); p1.setPrice(55454.0); p1.setQty(90.0); p1.setStatus("avaialable"); 
		try(ses){
			tx=ses.beginTransaction();
			int idVal=(int) ses.save(p1);
			System.out.println("id value::"+idVal);
			tx.commit();
		}
		catch(HibernateException he) {
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly())
				tx.rollback();
		}

	}

}
