//Product.java (Entity class)
package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;

@Entity
@Data
public class Product {
	
	/*@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id*/
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)*/
	
	/*@Id
	@SequenceGenerator(name = "gen1",sequenceName = "JPA_PID_SEQ",
	                                        initialValue = 700,allocationSize = 5)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)*/
	
	/*@Id
	@SequenceGenerator(name = "gen1",sequenceName = "JPA_PID_SEQ1")
	@GeneratedValue(generator="gen1",strategy = GenerationType.SEQUENCE)*/
	
	/*@Id
	@TableGenerator(name="gen1",pkColumnName = "ID_COL",
	                                 table = "ID_TAB",pkColumnValue = "PID",
	                                 valueColumnName = "VAL_COL",initialValue = 400,allocationSize = 2)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.TABLE)*/
	
	/*	@Id
		@GeneratedValue(strategy = GenerationType.TABLE)*/
	
	/*	//AUTO for oracle
		@Id  
		@GeneratedValue(strategy = GenerationType.AUTO)*/
	
	/*  //AUTO for oracle
	  @Id  
	@SequenceGenerator(name = "gen1",sequenceName = "JPA_PID_SEQ2",initialValue = 400,allocationSize = 10)
	@GeneratedValue(generator = "gen1",  strategy= GenerationType.AUTO)
	*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;
	@Column(length=20)
	private String pname;
	private Double price;
	private Double qty;
	@Column(length=20)
	private String status;
	
	public Product() {
	  System.out.println("Product:: 0-param constructor ::"+this.getClass()+"  "+System.identityHashCode(this)+"  "+this.getClass().getSuperclass());
	}


}
