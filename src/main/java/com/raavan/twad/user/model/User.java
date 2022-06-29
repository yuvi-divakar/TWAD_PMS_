
  package com.raavan.twad.user.model;
  
  import java.util.*; 
  import javax.persistence.Column; 
  import javax.persistence.Entity; 
  import javax.persistence.GeneratedValue; 
  import javax.persistence.GenerationType;
  import javax.persistence.Id; 
  import javax.persistence.Table; 
  import javax.persistence.UniqueConstraint; 
  import javax.validation.constraints.NotNull; 
  import javax.validation.constraints.Max; 
  import javax.validation.constraints.Min;
  import javax.validation.constraints.NotBlank; 
  import javax.validation.constraints.NotNull; 
  import javax.validation.constraints.Size; 
  import org.hibernate.annotations.CreationTimestamp; 
  import org.hibernate.annotations.UpdateTimestamp;
  
  @Entity
  @Table(name="TBL_USER",uniqueConstraints = {
  @UniqueConstraint(columnNames = "Email"),
  @UniqueConstraint(columnNames = "PasswordHash"), }) 
  public class User {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="UserID") 
  private int id;
  
  
  @NotNull(message = "FirstName may not be null")
  @Column(name="firstname") 
  private String firstname;
  
  @Size(max = 40)
  @Column(name="middlename") 
  private String middlename;
  
  
  @NotNull(message = "LastName may not be null")
  @Column(name="lastname") 
  private String lastname;
  
  
  @Size(max = 100)
  @Column(name="Mobile1") 
  private String mobile1;
  
  
  @Column(name="Mobile2") 
  private String mobile2;
  
  
  @NotNull(message = "Email may not be null")
  @Column(name="Email") 
  private String email;
  
  
  @NotNull(message = "Password may not be null")
  @Column(name="PasswordHash") 
  private String password;
  
  @Column(name="departmentId") 
  private int departmentId;
  
  @Column(name="CreatedBy") 
  private int created_by;
  
  @Column(name="UpdatedBy") 
  private int updated_by;
  
  @Column(name="CreatedOn") 
  private Date created_on;
  
  @Column(name="UpdatedOn") 
  private Date updated_on;
  
  @Column(name="IsActive") 
  private boolean isActive;
  
  public User() { }
  
  public User(int id, String firstname,String middlename,String lastname,String
  mobile1,String mobile2, String email,String password,int departmentId,int
  created_by,int updated_by,Date created_on, Date updated_on,boolean isActive)
  { 
	  this.id = id; 
	  this.firstname = firstname; 
	  this.middlename = middlename;
	  this.lastname = lastname; 
	  this.mobile1 = mobile1; 
	  this.mobile2 = mobile2;
	  this.email = email; 
	  this.password = password; 
	  this.departmentId = departmentId; 
	  this.created_by = created_by; 
	  this.updated_by = updated_by;
	  this.created_on = created_on; 
	  this.updated_on = updated_on; 
	  this.isActive = isActive;
  }

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getMiddlename() {
	return middlename;
}

public void setMiddlename(String middlename) {
	this.middlename = middlename;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public int getDepartmentId() {
	return departmentId;
}

public void setDepartmentId(int departmentId) {
	this.departmentId = departmentId;
}

public int getCreated_by() {
	return created_by;
}

public void setCreated_by(int created_by) {
	this.created_by = created_by;
}

public int getUpdated_by() {
	return updated_by;
}

public void setUpdated_by(int updated_by) {
	this.updated_by = updated_by;
}

public Date getCreated_on() {
	return created_on;
}

public void setCreated_on(Date created_on) {
	this.created_on = created_on;
}

public Date getUpdated_on() {
	return updated_on;
}

public void setUpdated_on(Date updated_on) {
	this.updated_on = updated_on;
}

public boolean isActive() {
	return isActive;
}

public void setActive(boolean isActive) {
	this.isActive = isActive;
}
  
  
  
  }  