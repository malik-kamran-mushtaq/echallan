package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.exceptions.ApiResponse;
import com.test.entity.LicenceEntity;
import com.test.exceptions.ApiResponse;
import com.test.entity.LicenceEntity;
import com.test.service.LicenceService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/licence")
@CrossOrigin("*")

@Api(value="", description="This controller manages the licence data. Through this you can view, add, update and delete licence data.")
public class LicenceController {
	
	@Autowired
	private LicenceService licenceService;
	
	@PostMapping("/")
	public ResponseEntity<LicenceEntity> addLicence(@RequestBody LicenceEntity licence){
		LicenceEntity saveLicence = this.licenceService.addLicence(licence);
		return new ResponseEntity<LicenceEntity>(saveLicence,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<LicenceEntity>> getAllLicence(){
		List<LicenceEntity> allLicence = this.licenceService.getAllLicence();
		return new ResponseEntity<List<LicenceEntity>>(allLicence,HttpStatus.OK);
	}
	
	@GetMapping("/{lic_no}")
	public ResponseEntity<LicenceEntity> getLicenceById(@PathVariable("lic_no") int lic_no){
		LicenceEntity licenceById = this.licenceService.getLicenceById(lic_no);
		return new ResponseEntity<LicenceEntity>(licenceById,HttpStatus.OK);
	}
	
	@PutMapping("/{lic_no}")
	public ResponseEntity<LicenceEntity> updateLicenceById(@RequestBody LicenceEntity licence,@PathVariable int lic_no) {
		LicenceEntity updatedLicence = licenceService.updateLicenceById(licence, lic_no);
		return new ResponseEntity<LicenceEntity>(updatedLicence,HttpStatus.OK);
	}
	
	@DeleteMapping("/{lic_no}")
	public ResponseEntity<ApiResponse> deleteLicenceById(@PathVariable("lic_no") int lic_no) {
		this.licenceService.deleteLicenceById(lic_no);
		ApiResponse response=new ApiResponse();
		response.setMessage("Licence record is deleted successfully with Licence number:"+lic_no);
		
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	}
	
	
	

}
