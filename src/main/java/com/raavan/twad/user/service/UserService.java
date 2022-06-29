package com.raavan.twad.user.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.raavan.twad.user.dao.CommonString;
import com.raavan.twad.user.dao.UserDetailsDAO;
import com.raavan.twad.user.dto.UserDetails;
import com.raavan.twad.user.exceptions.CustomValidationException;
import com.raavan.twad.user.model.User;
import com.raavan.twad.user.repository.UserRepository;



@Service
public class UserService {
	
	  @Autowired 
	  private UserRepository userRepository;
	  
	  @Autowired
	  private UserInfoImpl userInfoImpl;
	  
	  public Optional<User> create(User user){ 
		  if(userRepository.existsById(user.getId()))
		  { 
			  return Optional.empty(); 
		  }
		  else{
			  return Optional.of(userRepository.save(user)); 
		  } 
	  }
	  
	  public List<User> retrieve(int offset, int pagesize){ 
		  Pageable pager=PageRequest.of(offset, pagesize);
		  Page<User> PageResult= userRepository.findAll(pager);
		  return PageResult.toList(); 
	  } 
	  
	  public Optional<User> retrieveOne(int Userid){ 
		  return userRepository.findById(Userid); 
		  } 
	  
	  public Optional<User> update(User user){
	  if (userRepository.existsById(user.getId())){ 
		  return Optional.of(userRepository.save(user)); 
		  }
	  else{ 
		  return Optional.empty(); 
		  } 
	  }
	  
	  public String delete(int Userid){ 
		  if (userRepository.existsById(Userid)){
			  userRepository.deleteById(Userid);
			  return Userid + " deleted successfully!";
	  }
		  else{ 
			  return "The user data does not exist in records!"; 
			  }
	  
	  }
	  
	  public List<ResponseEntity> getAllUserDetails(int offset, int pagesize) throws ServiceException{
			 
		  List<ResponseEntity> users = new ArrayList<ResponseEntity>();
		  
		  int fromIndex=0;
		  int toIndex=0;
		  try {
			  List<UserDetails> usersList=  userInfoImpl.getAllUserDetails();
			  Integer listSize = usersList.size();
			  Integer totalPages;
			  
			  if(listSize%pagesize==0)
				  totalPages=(listSize/pagesize);
			  else
				  totalPages=(listSize/pagesize)+1;
			  
			  if(pagesize<=(listSize-1) && offset>0 && totalPages>1) {
				  fromIndex = (offset-1)*pagesize;
				  toIndex   = offset*pagesize;
			  }
			  else {
				  fromIndex = 0;
				  toIndex   = listSize;
			  }
			  
			  List<UserDetails> pageUserList = usersList.subList(fromIndex, toIndex);
				  
			  if(!pageUserList.isEmpty()) {
				  pageUserList.stream().forEach(user -> {
					  List<String> roles = new ArrayList<String>();
					  List<String> departments = new ArrayList<String>();
					  if(!user.getRoles().isBlank()) {
						  roles =Arrays.asList(user.getRoles().substring(1, user.getRoles().length()-1).split(","));
					  }
					  if(!user.getDepartments().isBlank()) {
						  departments = Arrays.asList(user.getDepartments().substring(1, user.getDepartments().length()-1).split(","));
					  }
					  UserDetailsDAO udd = new UserDetailsDAO(user.getId(),user.getUsername(),user.getEmail(),user.getMobile1(),user.getMobile2(),roles,departments,totalPages);
					 
					  users.add(udd);
				  });
			  }
		 }catch(Exception e) {
			 throw new CustomValidationException("Incorrect Details");
		 }
		return users;
	  }

	  public List<ResponseEntity> getAllUserDetailsByKeyword(int offset, int pagesize,String searchKeyword) throws ServiceException{
			 
		  List<ResponseEntity> users = new ArrayList<ResponseEntity>();
		  
		  int fromIndex=0;
		  int toIndex=0;
		  try {
			  List<UserDetails> usersList=  userInfoImpl.getAllUserDetailsByKeyword(searchKeyword);
			  
			  if(usersList.size()==0) {
				  users.add(new CommonString(0,"No Records Found"));
				  return users;
			  }
				  
			  Integer listSize = usersList.size();
			  Integer totalPages;
			  
			  if(listSize%pagesize==0)
				  totalPages=(listSize/pagesize);
			  else
				  totalPages=(listSize/pagesize)+1;
			  
			  if(offset>totalPages) {
				  return  (List<ResponseEntity>) new CustomValidationException("Requested page no. is greater than the total pages");
			  }
			  
			  if(pagesize<=(listSize-1) && offset>0 && totalPages>1) {
				  fromIndex = (offset-1)*pagesize;
				  toIndex   = offset*pagesize;
			  }
			  else {
				  fromIndex = 0;
				  toIndex   = listSize;
			  }
			  
			  List<UserDetails> pageUserList = usersList.subList(fromIndex, toIndex);
				  
			  if(!pageUserList.isEmpty()) {
				  pageUserList.stream().forEach(user -> {
					  List<String> roles = new ArrayList<String>();
					  List<String> departments = new ArrayList<String>();
					  if(!user.getRoles().isBlank()) {
						  roles =Arrays.asList(user.getRoles().substring(1, user.getRoles().length()-1).split(","));
					  }
					  if(!user.getDepartments().isBlank()) {
						  departments = Arrays.asList(user.getDepartments().substring(1, user.getDepartments().length()-1).split(","));
					  }
					  UserDetailsDAO udd = new UserDetailsDAO(user.getId(),user.getUsername(),user.getEmail(),user.getMobile1(),user.getMobile2(),roles,departments,totalPages);
					 
					  users.add(udd);
				  });
			  }
		 }catch(Exception e) {
			 e.printStackTrace();
			 //throw new CustomValidationException("Incorrect Details");
		 }
		return users;
	  }

	  
}
