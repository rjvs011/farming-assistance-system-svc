package com.demo.farmingassistancesystemsvc.service;

import java.util.List;
import java.util.Optional;

import com.demo.farmingassistancesystemsvc.model.Farmer;

public interface FarmerService {
	public Farmer saveFarmer(Farmer farmer);
	public List<Farmer> getAllFarmers();
	public Optional<Farmer> getFarmerById(Long id);

}
