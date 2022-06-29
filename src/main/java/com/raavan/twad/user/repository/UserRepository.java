
  package com.raavan.twad.user.repository;
  
  import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
  
  @Repository 
  public interface UserRepository extends JpaRepository<com.raavan.twad.user.model.User,Integer>{
  
  }
 