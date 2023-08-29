package com.test.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.LicenceEntity;
import com.test.exceptions.ResourceNotFoundException;
import com.test.repository.LicenceRepository;
import com.test.service.LicenceService;

@Service
public class LicenceServiceImplementation implements LicenceService{
	
	@Autowired
	private LicenceRepository licenceRepository;

	@Override
	public LicenceEntity addLicence(LicenceEntity licence) {
		return this.licenceRepository.save(licence);
	}

	@Override
	public List<LicenceEntity> getAllLicence() {
		return this.licenceRepository.findAll();
	}

	@Override
	public LicenceEntity getLicenceById(int lic_no) {
		return this.licenceRepository.findById(lic_no).orElseThrow(()->new ResourceNotFoundException("Licence", "Licence Number", lic_no));
	}

	@Override
	public LicenceEntity updateLicenceById(LicenceEntity licence, int lic_no) {
		if(!this.licenceRepository.existsById(lic_no)) {
			throw new ResourceNotFoundException("Licence", "Licence Number", lic_no);
		}
		return this.licenceRepository.save(licence);
	}

	@Override
	public void deleteLicenceById(int lic_no) {
		if(!this.licenceRepository.existsById(lic_no)) {
			throw new ResourceNotFoundException("Licence", "Licence Number", lic_no);
		}
		else {
			this.licenceRepository.deleteById(lic_no);
		}
		
	}
	
	

}
