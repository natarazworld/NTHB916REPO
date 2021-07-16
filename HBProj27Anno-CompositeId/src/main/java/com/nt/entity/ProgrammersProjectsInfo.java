package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data	
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PROGRAMMERS_PROJECTS_INFO")
public class ProgrammersProjectsInfo {
	@EmbeddedId
	private PrgmrProjId id; //HAS- Property

	@Column(length=20)
	@Type(type="string")  //optional
    private String pname;
	
	@Column(length=20)
	@Type(type="string")
    private  String projName;
     @Type(type="int")
	private  Integer teamSize;
}
