package com.raavan.twad.division.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DivisionService {
	
	@Autowired
	  private DivisionInfoImpl userInfoImpl;
	 @PersistenceContext
	    private EntityManager entityManager;
	
	public String getDivisions()  {
		
		//List<DivisionDAO> users = new ArrayList<DivisionDAO>();
		 //List<DivisionDetails> usersList=  userInfoImpl.getDivisions();
		 return  userInfoImpl.getDivisions();
		
   }
}
