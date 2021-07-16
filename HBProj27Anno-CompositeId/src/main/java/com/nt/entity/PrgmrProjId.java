package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PrgmrProjId implements Serializable {
	@Type(type="int")
	private Integer pid;
	@Type(type="int")
	private Integer projId;

}
