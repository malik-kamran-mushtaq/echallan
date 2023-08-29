package com.test.service;

import java.util.List;

import com.test.entity.ChallanEntity;

public interface ChallanService {
	
public ChallanEntity addChallan(ChallanEntity challan);
	
	public List<ChallanEntity> getAllChallan();
	
	public ChallanEntity getChallanById(int challan_no);
	
	public ChallanEntity updateChallanById(ChallanEntity challan, int challan_no);
	
	public void deleteChallanById(int challan_no);

}
