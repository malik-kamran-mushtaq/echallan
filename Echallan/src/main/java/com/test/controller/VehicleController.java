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

import com.test.entity.UserEntity;
import com.test.entity.VehicleEntity;
import com.test.entity.VehicleEntity;
import com.test.exceptions.ApiResponse;
import com.test.service.VehicleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin("*")

@Api(value="", description="This controller manages the vehicle details. Through this you can view, add, update and delete vehicle details.")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;

	@PostMapping("/")
	public ResponseEntity<VehicleEntity> addVehicle(@RequestBody VehicleEntity vehicle) {
		VehicleEntity saveVehicle = this.vehicleService.addVehicle(vehicle);
		return new ResponseEntity<VehicleEntity>(saveVehicle, HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<List<VehicleEntity>> getAllVehicles() {
		List<VehicleEntity> allVehicles = this.vehicleService.getAllVehicles();
		return new ResponseEntity<List<VehicleEntity>>(allVehicles, HttpStatus.OK);
	}

	@ApiOperation(value="Adding vehicle details. Here you can add the vehicle details.",
			notes="You can add the user from here",
			response=VehicleEntity.class)
	@GetMapping("/{vehicle_no}")
	public ResponseEntity<VehicleEntity> getVehicleById(@PathVariable("vehicle_no") int vehicle_no) {
		VehicleEntity vehicleById = this.vehicleService.getVehicleById(vehicle_no);
		return new ResponseEntity<VehicleEntity>(vehicleById, HttpStatus.OK);
	}

	@PutMapping("/{vehicle_no}")
	public ResponseEntity<VehicleEntity> updateVehicleById(@RequestBody VehicleEntity vehicle, @PathVariable int vehicle_no) {
		VehicleEntity updatedVehicle = vehicleService.updateVehicleById(vehicle, vehicle_no);
		return new ResponseEntity<VehicleEntity>(updatedVehicle, HttpStatus.OK);
	}

	@DeleteMapping("/{vehicle_no}")
	public ResponseEntity<ApiResponse> deleteVehicleById(@PathVariable("vehicle_no") int vehicle_no) {
		this.vehicleService.deleteVehicleById(vehicle_no);
		ApiResponse response = new ApiResponse();
		response.setMessage("Vehicle record is deleted successfully with Vehicle number:" + vehicle_no);

		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
	}

}
