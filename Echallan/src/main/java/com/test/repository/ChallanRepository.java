package com.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entity.ChallanEntity;
import com.test.entity.UserEntity;

public interface ChallanRepository extends JpaRepository<ChallanEntity, Integer>{
	
	List<ChallanEntity> findByUser1(UserEntity user);

}
