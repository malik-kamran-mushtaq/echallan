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

import com.test.entity.ChallanEntity;
import com.test.exceptions.ApiResponse;
import com.test.service.ChallanService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/challan")
@CrossOrigin("*")

@Api(value="Donor", description="This controller manages the challan details. Through this you can view, add, update and delete challan.")
public class ChallanController {
	
	@Autowired
	private ChallanService challanService;
	
	@PostMapping("/")
	public ResponseEntity<ChallanEntity> addChallan(@RequestBody ChallanEntity challan){
		ChallanEntity saveChallan = this.challanService.addChallan(challan);
		return new ResponseEntity<ChallanEntity>(saveChallan,HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<List<ChallanEntity>> getAllChallan(){
		List<ChallanEntity> allChallan = this.challanService.getAllChallan();
		return new ResponseEntity<List<ChallanEntity>>(allChallan,HttpStatus.OK);
	}
	
	@GetMapping("/{challan_no}")
	public ResponseEntity<ChallanEntity> getChallanById(@PathVariable("challan_no") int challan_no){
		ChallanEntity challanById = this.challanService.getChallanById(challan_no);
		return new ResponseEntity<ChallanEntity>(challanById,HttpStatus.OK);
	}
	
	@PutMapping("/{challan_no}")
	public ResponseEntity<ChallanEntity> updateChallanById(@RequestBody ChallanEntity challan,@PathVariable int challan_no) {
		ChallanEntity updatedChallan = challanService.updateChallanById(challan, challan_no);
		return new ResponseEntity<ChallanEntity>(updatedChallan,HttpStatus.OK);
	}
	
	@DeleteMapping("/{challan_no}")
	public ResponseEntity<ApiResponse> deleteLicenceById(@PathVariable("challan_no") int challan_no) {
		this.challanService.deleteChallanById(challan_no);
		ApiResponse response=new ApiResponse();
		response.setMessage("Challan record is deleted successfully with Challan number:"+challan_no);
		
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	}

}
