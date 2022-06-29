package com.raavan.twad.user.dao;

import java.io.Serializable;

import javax.persistence.Id;

import com.raavan.twad.user.service.ResponseEntity;



public class CommonString implements ResponseEntity , Serializable{

	private static final long serialVersionUID = -5913171076891976585L;
	
	@Id
	private Integer id;
	private String stringValue;
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getStringValue() {
		return stringValue;
	}


	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}


	public CommonString(Integer id, String stringValue) {
		super();
		this.id = id;
		this.stringValue = stringValue;
	}
	
	
}
