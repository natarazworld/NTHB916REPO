package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name="ARTIST")
@Data
@AllArgsConstructor
public class Artist implements Serializable {
	@Id
	@Column(name="AID")
	private Integer aid;
	@Column(name="NAME",length = 15)
	private String name;
	@Column(name="ADDRS")
	private String addrs;
	@Column(name="MobileNo")
	private Long mobileNO;
	@Column(name="CATEGORY",length = 15)
	private String category;
	
	

}
