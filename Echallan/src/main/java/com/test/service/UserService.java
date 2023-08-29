package com.test.service;

import java.util.List;

import com.test.entity.UserEntity;

public interface UserService {
	
	public UserEntity addUser(UserEntity user);
	
	public List<UserEntity> getAllUsers();
	
	public UserEntity getUserById(int lic_no);
	
	public UserEntity updateUserById(UserEntity user, int lic_no);
	
	public void deleteUserById(int lic_no);
	
	public UserEntity userLogin(String username,String password);



}
