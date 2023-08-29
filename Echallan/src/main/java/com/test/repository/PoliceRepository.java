package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entity.PoliceEntity;

public interface PoliceRepository extends JpaRepository<PoliceEntity, Integer>{
	PoliceEntity findByUsernameAndPassword(String username, String password);

}
