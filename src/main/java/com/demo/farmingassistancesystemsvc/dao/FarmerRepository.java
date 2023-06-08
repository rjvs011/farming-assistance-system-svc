package com.demo.farmingassistancesystemsvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.farmingassistancesystemsvc.model.Farmer;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Long> {
    // Add custom query methods if needed
}
