package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entity.VehicleEntity;

public interface VehicleRepository extends JpaRepository<VehicleEntity, Integer>{

}
