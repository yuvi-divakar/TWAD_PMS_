package com.raavan.twad.user.dto;

import java.io.Serializable;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import com.raavan.twad.user.service.ResponseEntity;



@Entity
@SqlResultSetMapping(
		name = "map_userDetails",
		classes = @ConstructorResult(
			targetClass = UserDetails.class,
			columns = {
				@ColumnResult(name = "id", type=Integer.class),
				@ColumnResult(name = "username",type=String.class),
				@ColumnResult(name = "email",type=String.class),
				@ColumnResult(name = "mobile1",type=String.class),
				@ColumnResult(name = "mobile2",type=String.class),
				@ColumnResult(name = "roles",type=String.class),
				@ColumnResult(name = "departments",type=String.class)
			}
		)		
)
public class UserDetails implements ResponseEntity, Serializable{

	
	
	private static final long serialVersionUID = -2531766459527089208L;
	
	@Id
	private Integer id;
	private String username;
	private String email;
	private String mobile1;
	private String mobile2;
	private String roles;
	private String departments;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile1() {
		return mobile1;
	}
	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}
	public String getMobile2() {
		return mobile2;
	}
	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getDepartments() {
		return departments;
	}
	public void setDepartments(String departments) {
		this.departments = departments;
	}
	
	public UserDetails(Integer id, String username, String email, String mobile1, String mobile2, String roles,
			String departments) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.mobile1 = mobile1;
		this.mobile2 = mobile2;
		this.roles = roles;
		this.departments = departments;
	}
	
	
	
}
