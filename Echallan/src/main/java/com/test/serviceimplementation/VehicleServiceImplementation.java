package com.test.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.VehicleEntity;
import com.test.exceptions.ResourceNotFoundException;
import com.test.repository.VehicleRepository;
import com.test.service.VehicleService;

@Service
public class VehicleServiceImplementation implements VehicleService{
	
	@Autowired
	private VehicleRepository vehicleRepository;

	@Override
	public VehicleEntity addVehicle(VehicleEntity vehicle) {
		// TODO Auto-generated method stub
		return this.vehicleRepository.save(vehicle);
	}

	@Override
	public List<VehicleEntity> getAllVehicles() {
		// TODO Auto-generated method stub
		return this.vehicleRepository.findAll();
	}

	@Override
	public VehicleEntity getVehicleById(int vehicle_no) {
		// TODO Auto-generated method stub
		return this.vehicleRepository.findById(vehicle_no).orElseThrow(()->new ResourceNotFoundException("Vehicle", "Vehicle Number", vehicle_no));

	}

	@Override
	public VehicleEntity updateVehicleById(VehicleEntity vehicle, int vehicle_no) {
		// TODO Auto-generated method stub
		if(!this.vehicleRepository.existsById(vehicle_no)) {
			throw new ResourceNotFoundException("Vehicle", "Vehicle Number", vehicle_no);
		}
		return this.vehicleRepository.save(vehicle);
	}
	

	@Override
	public void deleteVehicleById(int vehicle_no) {
		// TODO Auto-generated method stub
		if(!this.vehicleRepository.existsById(vehicle_no)) {
			throw new ResourceNotFoundException("Vehicle", "Vehicle Number", vehicle_no);
		}
		else {
			this.vehicleRepository.deleteById(vehicle_no);
		}
		
		
	}

}
