package com.nt.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class MobilePhoneUser {
	private  Long regNo;
	@NonNull
	private Long mobileNo;
	@NonNull
	private  boolean prepaid;  //gives  isPrepaid() instread of getPrepaid
	@NonNull
	private  String circle;
	@NonNull
	private String callerTune;
	
	private  Integer updationsCount;
	

}
