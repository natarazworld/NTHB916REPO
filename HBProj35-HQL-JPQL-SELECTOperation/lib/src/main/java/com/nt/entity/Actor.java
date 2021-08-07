package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Actor implements Serializable {
	private Integer actorId;
	private String actorName;
	private String actorAddrs;
	private  Long mobileNo;
	
	public Actor(){
		System.out.println("Actor:: 0-param constructor---->"+this.getClass());
	}

}
