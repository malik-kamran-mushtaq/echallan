package com.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Vehicle")
public class VehicleEntity {

	@Id
	private int vehicle_no;
	
	@Column(nullable = false, length = 20)
	private String model_name;
	
	@Column(nullable = false)
	private int model_year;
	
	@Column(nullable = false, length = 30)
	private String owner;

	public int getVehicle_no() {
		return vehicle_no;
	}

	public void setVehicle_no(int vehicle_no) {
		this.vehicle_no = vehicle_no;
	}

	public String getModel_name() {
		return model_name;
	}

	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}

	public int getModel_year() {
		return model_year;
	}

	public void setModel_year(int model_year) {
		this.model_year = model_year;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public VehicleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "VehicleEntity [vehicle_no=" + vehicle_no + ", model_name=" + model_name + ", model_year=" + model_year
				+ ", owner=" + owner + "]";
	}
	
	
}
