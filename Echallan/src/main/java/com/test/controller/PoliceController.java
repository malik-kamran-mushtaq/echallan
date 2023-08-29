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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.PoliceEntity;
import com.test.entity.UserEntity;
import com.test.exceptions.ApiResponse;
import com.test.service.PoliceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/police")
@CrossOrigin("*")

@Api(value="", description="This controller manages the police data. Through this you can view, add, update and delete police data.")
public class PoliceController {

	
	@Autowired
	private PoliceService policeService;

	@PostMapping("/")
	@ApiOperation(value="Adding the user. This part is used to add the user.",
	notes="You can add the user from here",
	response=UserEntity.class)
	
	public ResponseEntity<PoliceEntity> addPolice(@RequestBody PoliceEntity police) {
		PoliceEntity savePolice = this.policeService.addPolice(police);
		return new ResponseEntity<PoliceEntity>(savePolice, HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<List<PoliceEntity>> getAllPolice() {
		List<PoliceEntity> allPolice = this.policeService.getAllPolice();
		return new ResponseEntity<List<PoliceEntity>>(allPolice, HttpStatus.OK);
	}

	@GetMapping("/{emp_id}")
	public ResponseEntity<PoliceEntity> getPoliceById(@PathVariable("emp_id") int emp_id) {
		PoliceEntity policeById = this.policeService.getPoliceById(emp_id);
		return new ResponseEntity<PoliceEntity>(policeById, HttpStatus.OK);
	}

	@PutMapping("/{emp_id}")
	public ResponseEntity<PoliceEntity> updatePoliceById(@RequestBody PoliceEntity police, @PathVariable int emp_id) {
		PoliceEntity updatedPolice = policeService.updatePoliceById(police, emp_id);
		return new ResponseEntity<PoliceEntity>(updatedPolice, HttpStatus.OK);
	}

	@DeleteMapping("/{emp_id}")
	public ResponseEntity<ApiResponse> deletePoliceById(@PathVariable("emp_id") int emp_id) {
		this.policeService.deletePoliceById(emp_id);
		ApiResponse response = new ApiResponse();
		response.setMessage("Police record is deleted successfully with Employee ID:" + emp_id);

		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
	}
	
	@GetMapping("/check1")
	public ResponseEntity<PoliceEntity> checkLogin(@RequestParam("username") String username, @RequestParam("password") String password){
		
		PoliceEntity policeLogin=this.policeService.policeLogin(username, password);
		if(policeLogin!=null) {
			return new ResponseEntity<PoliceEntity>(policeLogin,HttpStatus.OK);
		}
		else {
			return null;
		}
	}

}
