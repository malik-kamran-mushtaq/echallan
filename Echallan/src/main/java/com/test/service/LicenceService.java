package com.test.service;

import java.util.List;

import com.test.entity.LicenceEntity;

public interface LicenceService {
	
	//To add a new Licence record
	public LicenceEntity addLicence(LicenceEntity licence);
	
	//To ge all the records
	public List<LicenceEntity> getAllLicence();
	
	//Get the record of single licence
	public LicenceEntity getLicenceById(int lic_no);
	
	//Update licence by ID
	public LicenceEntity updateLicenceById(LicenceEntity licence, int lic_no);
	
	//Delete licence by ID
	public void deleteLicenceById(int lic_no);
	
	

}
