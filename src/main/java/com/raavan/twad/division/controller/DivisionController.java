package com.raavan.twad.division.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raavan.twad.TwadPmsApplication;
import com.raavan.twad.division.service.DivisionService;

@RestController
@RequestMapping("/api/v1")
public class DivisionController {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TwadPmsApplication.class);

	
	@Autowired
	DivisionService Divservice;
	
	@GetMapping(path="/getDivisions",produces=MediaType.APPLICATION_JSON_VALUE)
	  public String getDivisions() {
		  
	      return Divservice.getDivisions();
	    }
}
