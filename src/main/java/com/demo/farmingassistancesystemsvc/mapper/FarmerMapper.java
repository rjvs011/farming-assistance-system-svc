package com.demo.farmingassistancesystemsvc.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.demo.farmingassistancesystemsvc.dto.FarmerDto;
import com.demo.farmingassistancesystemsvc.model.Farmer;

@Component
public class FarmerMapper {
	public Farmer toEntity(FarmerDto farmerDto) {
		Farmer farmer = new Farmer();
		farmer.setId(farmerDto.getId());
		farmer.setName(farmerDto.getName());
		farmer.setEmail(farmerDto.getEmail());
		// Map any other fields from DTO to Entity if needed
		return farmer;
	}

	public FarmerDto toDto(Farmer farmer) {
		FarmerDto farmerDTO = new FarmerDto();
		farmerDTO.setId(farmer.getId());
		farmerDTO.setName(farmer.getName());
		farmerDTO.setEmail(farmer.getEmail());
		// Map any other fields from Entity to DTO if needed
		return farmerDTO;
	}

	public List<FarmerDto> toDtoList(List<Farmer> farmers) {
		return farmers.stream().map(this::toDto).collect(Collectors.toList());
	}
}
