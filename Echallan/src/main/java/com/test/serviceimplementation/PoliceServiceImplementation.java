package com.test.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.PoliceEntity;
import com.test.entity.UserEntity;
import com.test.exceptions.ResourceNotFoundException;
import com.test.repository.PoliceRepository;
import com.test.service.PoliceService;

@Service
public class PoliceServiceImplementation implements PoliceService {

	@Autowired
	private PoliceRepository policeRepository;

	@Override
	public PoliceEntity addPolice(PoliceEntity police) {
		return this.policeRepository.save(police);
	}

	@Override
	public List<PoliceEntity> getAllPolice() {
		return this.policeRepository.findAll();
	}

	@Override
	public PoliceEntity getPoliceById(int emp_id) {
		return this.policeRepository.findById(emp_id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "Employee ID", emp_id));

	}

	@Override
	public PoliceEntity updatePoliceById(PoliceEntity police, int emp_id) {
		if (!this.policeRepository.existsById(emp_id)) {
			throw new ResourceNotFoundException("Employee", "Employee ID", emp_id);
		}
		return this.policeRepository.save(police);
	}

	@Override
	public void deletePoliceById(int emp_id) {
		if (!this.policeRepository.existsById(emp_id)) {
			throw new ResourceNotFoundException("Employee", "Employee ID", emp_id);
		} else {
			this.policeRepository.deleteById(emp_id);
		}

	}

	@Override
	public PoliceEntity policeLogin(String username, String password) {
		PoliceEntity police=this.policeRepository.findByUsernameAndPassword(username, password);
		return police;
	}
	
	

}
