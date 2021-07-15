package com.nt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data	
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammersProjectsInfo {
	private PrgmrProjId id; //HAS- Property
    private String pname;
    private  String projName;
    private  Integer teamSize;
}
