package com.test.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.UserEntity;
import com.test.exceptions.ResourceNotFoundException;
import com.test.repository.UserRepository;
import com.test.service.UserService;

@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserEntity addUser(UserEntity user) {
		return this.userRepository.save(user);
	}

	@Override
	public List<UserEntity> getAllUsers() {
		return this.userRepository.findAll();
	}

	@Override
	public UserEntity getUserById(int lic_no) {
		return this.userRepository.findById(lic_no).orElseThrow(()->new ResourceNotFoundException("Licence", "Licence Number", lic_no));

	}

	@Override
	public UserEntity updateUserById(UserEntity user, int lic_no) {
		if(!this.userRepository.existsById(lic_no)) {
			throw new ResourceNotFoundException("Licence", "Licence Number", lic_no);
		}
		return this.userRepository.save(user);
	}

	@Override
	public void deleteUserById(int lic_no) {
		if(!this.userRepository.existsById(lic_no)) {
			throw new ResourceNotFoundException("Licence", "Licence Number", lic_no);
		}
		else {
			this.userRepository.deleteById(lic_no);
		}
		
	}

	@Override
	public UserEntity userLogin(String username, String password) {
		UserEntity user=this.userRepository.findByUsernameAndPassword(username, password);
		return user;
	}

	
	
	

}
