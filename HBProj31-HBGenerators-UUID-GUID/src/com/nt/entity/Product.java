//Product.java (Entity class)
package com.nt.entity;

import lombok.Data;

@Data
public class Product {
	// bean propertes
	private String pid;
	private String pname;
	private Double price;
	private double qty;
	private String status;
	
	public Product() {
	  System.out.println("Product:: 0-param constructor ::"+this.getClass()+"  "+System.identityHashCode(this)+"  "+this.getClass().getSuperclass());
	}


	// toString() ( (alt+shift+s, s)
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", qty=" + qty + ", status=" + status
				+ "]";
	}

}
