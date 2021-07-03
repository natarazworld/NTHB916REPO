//Product.java (Entity class)
package com.nt.entity;

import lombok.Data;

@Data
public class Product {
	// bean propertes
	private Integer pid;
	private String pname;
	private Double price;
	private Double qty;
	private String status;
	
}
