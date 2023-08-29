package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entity.LicenceEntity;

public interface LicenceRepository extends JpaRepository<LicenceEntity, Integer> {

}
