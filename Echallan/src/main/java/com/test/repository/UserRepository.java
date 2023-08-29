package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	
	UserEntity findByUsernameAndPassword(String username,String password);



}
