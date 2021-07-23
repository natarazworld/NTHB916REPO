package com.nt.scheduling;

import java.util.TimerTask;

import org.hibernate.Session;

public class L1CacheEmptyingService  extends TimerTask {
	 private Session ses;
	public L1CacheEmptyingService(Session ses) {
		System.out.println("L1CacheEmptyingService.L1CacheEmptyingService()");
		this.ses=ses;
	}
	

	@Override
	public void run() {
		System.out.println("L1CacheEmptyingService.run()");
	     ses.clear();
	}

}
