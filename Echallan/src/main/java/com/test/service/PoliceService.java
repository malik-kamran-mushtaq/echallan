package com.test.service;

import java.util.List;

import com.test.entity.PoliceEntity;
import com.test.entity.UserEntity;

public interface PoliceService {

	public PoliceEntity addPolice(PoliceEntity police);

	public List<PoliceEntity> getAllPolice();

	public PoliceEntity getPoliceById(int emp_id);

	public PoliceEntity updatePoliceById(PoliceEntity police, int emp_id);

	public void deletePoliceById(int emp_id);
	
	public PoliceEntity policeLogin(String username,String password);


}
