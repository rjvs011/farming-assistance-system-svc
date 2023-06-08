package com.demo.farmingassistancesystemsvc.controller;

import com.demo.farmingassistancesystemsvc.dto.FarmerDto;
import com.demo.farmingassistancesystemsvc.mapper.FarmerMapper;
import com.demo.farmingassistancesystemsvc.model.Farmer;
import com.demo.farmingassistancesystemsvc.service.FarmerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class FarmerController {

    private final FarmerService farmerService;
    private final FarmerMapper farmerMapper;

    public FarmerController(FarmerService farmerService, FarmerMapper farmerMapper) {
        this.farmerService = farmerService;
        this.farmerMapper = farmerMapper;
    }

    @PostMapping(value = "/farmerAssistanceService/farmer")
    public ResponseEntity<FarmerDto> createFarmer(@RequestBody FarmerDto farmerDTO) {
        Farmer farmer = farmerMapper.toEntity(farmerDTO);
        Farmer savedFarmer = farmerService.saveFarmer(farmer);
        FarmerDto savedFarmerDTO = farmerMapper.toDto(savedFarmer);
        return ResponseEntity.ok(savedFarmerDTO);
    }

    @GetMapping
    public ResponseEntity<List<FarmerDto>> getAllFarmers() {
        List<Farmer> farmers = farmerService.getAllFarmers();
        List<FarmerDto> farmerDTOs = farmerMapper.toDtoList(farmers);
        return ResponseEntity.ok(farmerDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FarmerDto> getFarmerById(@PathVariable Long id) {
        Optional<Farmer> farmer = farmerService.getFarmerById(id);
        return farmer.map(value -> ResponseEntity.ok(farmerMapper.toDto(value)))
                .orElse(ResponseEntity.notFound().build());
    }
}
