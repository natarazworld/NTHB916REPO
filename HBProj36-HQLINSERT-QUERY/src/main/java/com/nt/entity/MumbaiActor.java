package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class MumbaiActor implements Serializable {
	private Integer actorId;
	private String actorName;
	private String actorAddrs;
	private  Long mobileNo;
}
