//Product.java (Entity class)
package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;

@Entity
@Data
public class Product {
	// bean propertes
	/*@Id
	@GenericGenerator(name="gen1",strategy = "increment")
	@GeneratedValue(generator = "gen1")*/
	
	/*@Id
	@GenericGenerator(name="gen1",strategy = "identity")
	@GeneratedValue(generator = "gen1")*/
	
	/*@Id
	@GenericGenerator(name="gen1",strategy = "sequence")
	@GeneratedValue(generator = "gen1")
	*/
	
	/*@Id
	@GenericGenerator(name="gen1",strategy = "sequence",
	                                      parameters = @Parameter(name = "sequence_name", value = "PROD_ID_SEQ"))
	@GeneratedValue(generator = "gen1")
	*/
	
	/*@Id
	@GenericGenerator(name="gen1",strategy = "sequence",
	                                      parameters = { @Parameter(name = "sequence_name", value = "PRD_ID_SEQ"),
	                                    		                    @Parameter(name = "initial_value", value ="500"),
	                                    		                    @Parameter(name = "increment_size", value ="5")
	                                    		                      }       )
	@GeneratedValue(generator = "gen1")*/
	
	@Id
	@GenericGenerator(name="gen1",strategy = "seqhilo",
	                                      parameters = { @Parameter(name = "sequence_name", value = "PRODD_ID_SEQ"),
	                                    		                    @Parameter(name="initial_value", value="100"),
	                                    		                    @Parameter(name = "max_lo", value ="2")
	                                    		                      }       )
	@GeneratedValue(generator = "gen1")
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
