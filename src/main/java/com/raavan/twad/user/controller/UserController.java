package com.raavan.twad.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.raavan.twad.user.dto.UserDetails;
import com.raavan.twad.user.model.User;
import com.raavan.twad.user.service.UserService;

@CrossOrigin(origins="*", maxAge=3600)
@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
    private UserService userService;
	
	
	  @PostMapping("/create-user") 
	  public String saveUser(@RequestBody User user) {
	  Optional<User> _user = userService.create(user); 
	  if(_user.isPresent()){
		  return "The user data has been saved successfully!"; }
	  else{ 
		  return "User already exist in records"; 
		  } 
	  }
	  
	  @GetMapping("/getUserById/{id}") 
	  public ResponseEntity<User> getUserById(@PathVariable("id") int id) { 
		  Optional<User> user =userService.retrieveOne(id); 
		  if (user.isPresent()) { 
			  return new ResponseEntity<>(user.get(), HttpStatus.OK); } 
		  else { return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		  } 
	  }
	  
	  @GetMapping("/getALLUsers/{offset}/{pagesize}") 
	  public List<User> getALLUsers(@PathVariable int offset, @PathVariable int pagesize) { 
		  return userService.retrieve(offset,pagesize); }
	  
	  @PutMapping("/updateUser") 
	  public String updateUser(@RequestBody User user) {
	  Optional<User> _user = userService.update(user); 
	  if(_user.isEmpty()){ 
		  return "The user data does not exist in records!"; 
	  }
	  else{ 
		  return "The user data has been updated successfully!"; 
		  } 
	  }
	  
	  @DeleteMapping("/delete/{id}") 
	  public String deleteUserById(@PathVariable("id") int id) { 
		  return userService.delete(id); 
	  }
	    
		/*
		 * @GetMapping("/getAllUserDetails/{offset}/{pagesize}") public
		 * List<UserDetailsDAO> getAllUserDetails(@PathVariable int
		 * offset, @PathVariable int pagesize) { return
		 * userService.getAllUserDetails(offset,pagesize); }
		 */
		
		  @GetMapping("/getAllUserDetails/{offset}/{pagesize}") 
		  public List<com.raavan.twad.user.service.ResponseEntity> getAllUserDetails(@PathVariable int offset, @PathVariable int pagesize) {
			  return userService.getAllUserDetails(offset,pagesize); 
		  }
		 
		  
		  @GetMapping(value={"/getAllUserDetails1/{offset}/{pagesize}"}) 
		  public List<com.raavan.twad.user.service.ResponseEntity> getAllUserDetails1(@PathVariable int offset, @PathVariable int pagesize, @RequestParam   Optional<String> searchKeyword) {
			  if(null!=searchKeyword && !searchKeyword.isEmpty())
				  return userService.getAllUserDetailsByKeyword(offset,pagesize,searchKeyword.get());
			  else
				  return userService.getAllUserDetails(offset,pagesize); 
		  }
	    
	    
		  @PostMapping("/saveUserDetails") 
		  public String saveUserDetails(@RequestBody UserDetails userDetails) {
			return null;
			  
		  }
}
