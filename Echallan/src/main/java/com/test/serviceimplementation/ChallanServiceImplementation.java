package com.test.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.ChallanEntity;
import com.test.exceptions.ResourceNotFoundException;
import com.test.repository.ChallanRepository;
import com.test.service.ChallanService;

@Service
public class ChallanServiceImplementation implements ChallanService{
	
	@Autowired
	private ChallanRepository challanRepository;

	@Override
	public ChallanEntity addChallan(ChallanEntity challan) {
		return this.challanRepository.save(challan);
	}

	@Override
	public List<ChallanEntity> getAllChallan() {
		return this.challanRepository.findAll();
	}

	@Override
	public ChallanEntity getChallanById(int challan_no) {
		return this.challanRepository.findById(challan_no).orElseThrow(()->new ResourceNotFoundException("Challan", "Challan Number", challan_no));

	}

	@Override
	public ChallanEntity updateChallanById(ChallanEntity challan, int challan_no) {
		if(!this.challanRepository.existsById(challan_no)) {
			throw new ResourceNotFoundException("Challan", "Challan Number", challan_no);
		}
		return this.challanRepository.save(challan);
	}

	@Override
	public void deleteChallanById(int challan_no) {
		if(!this.challanRepository.existsById(challan_no)) {
			throw new ResourceNotFoundException("Challan", "Challan Number", challan_no);
		}
		else {
			this.challanRepository.deleteById(challan_no);
		}
	}

}
