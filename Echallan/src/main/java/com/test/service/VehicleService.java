package com.test.service;

import java.util.List;

import com.test.entity.VehicleEntity;

public interface VehicleService {
	
	public VehicleEntity addVehicle(VehicleEntity vehicle);

	public List<VehicleEntity> getAllVehicles();

	public VehicleEntity getVehicleById(int vehicle_no);

	public VehicleEntity updateVehicleById(VehicleEntity vehicle, int vehicle_no);

	public void deleteVehicleById(int vehicle_no);

	

}
