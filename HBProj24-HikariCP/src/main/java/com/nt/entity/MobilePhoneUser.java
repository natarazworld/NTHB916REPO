package com.nt.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="MOBILE_PHONE_USER_TS_VER")
public class MobilePhoneUser {
	@Id
	private  Long regNo;
	@NonNull
	private Long mobileNo;
	@NonNull
	private  boolean prepaid;  //gives  isPrepaid() instread of getPrepaid
	@NonNull
	private  String circle;
	@NonNull
	private String callerTune;
	
	@CreationTimestamp
	private Timestamp doj;
	@UpdateTimestamp
	private Timestamp lastUpdated;
	@Version
	private  Integer  updationCount;
	

}
