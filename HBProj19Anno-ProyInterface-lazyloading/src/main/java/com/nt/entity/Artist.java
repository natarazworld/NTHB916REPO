package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.Proxy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ARTIST")
@Data
@AllArgsConstructor
//@NoArgsConstructor
//@DynamicInsert(value=true)
@DynamicInsert(true)
@Proxy(lazy = true,proxyClass =IArtist.class)
public final class Artist implements Serializable,IArtist {
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
	public Artist() {
		System.out.println("Artist:: 0-param constructor::"+this.getClass());
	}
	

}
