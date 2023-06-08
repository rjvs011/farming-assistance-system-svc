package com.demo.farmingassistancesystemsvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.farmingassistancesystemsvc.dao.FarmerRepository;
import com.demo.farmingassistancesystemsvc.model.Farmer;

@Service
public class FarmerServiceImpl implements FarmerService {

	@Autowired
	private FarmerRepository farmerRepository;

	@Override
	public Farmer saveFarmer(Farmer farmer) {
		return farmerRepository.save(farmer);
	}

	@Override
	public List<Farmer> getAllFarmers() {
		return farmerRepository.findAll();
	}

	@Override
	public Optional<Farmer> getFarmerById(Long id) {
		return farmerRepository.findById(id);
	}

}
