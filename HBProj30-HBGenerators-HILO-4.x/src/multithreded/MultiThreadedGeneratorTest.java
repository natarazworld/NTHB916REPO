package multithreded;

import org.hibernate.Session;

import com.nt.utility.HibernateUtil;

public class MultiThreadedGeneratorTest {

	public static void main(String[] args) {
		
		MyRequest  req1=new MyRequest();
		MyRequest  req2=new MyRequest();
		MyRequest  req3=new MyRequest();
		Thread t1=new Thread(req1,"thread1");
		Thread t2=new Thread(req2,"thread2");
		Thread t3=new Thread(req3,"thread3");
		t1.start();
		t2.start();
		t3.start();
		
		//HibernateUtil.closeSessionFactory();
		
		

	}

}
