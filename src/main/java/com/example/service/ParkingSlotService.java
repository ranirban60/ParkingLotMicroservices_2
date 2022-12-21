package com.example.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dto.LoginDto;
import com.example.dto.ParkingSlotDto;
import com.example.exception.ParkingSlotException;
import com.example.model.ParkingSlotModel;
import com.example.repository.IParkingSlotRepo;

@Service
public class ParkingSlotService implements IParkingSlotService {

	@Autowired
	IParkingSlotRepo parkingSlotRepo;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public List<ParkingSlotModel> checkSpecificParkingSlotIsAvailable() {
		List<ParkingSlotModel> parkingSlot = parkingSlotRepo.findAll();
		if (parkingSlot.isEmpty()) {
			throw new ParkingSlotException("ParkingSlot is available");
		} else
			return parkingSlot;
	}

	@Override
	public ParkingSlotDto doParkVehicle(ParkingSlotDto parkingSlotDto) {
		ParkingSlotModel parking = modelMapper.map(parkingSlotDto, ParkingSlotModel.class);
		int number = parkingSlotRepo.findBySlotAvailable(true).size();
		System.out.println(number);
		if (number <= 20) {
			parking.setEntryTime(LocalDateTime.now());
			parking.setSlotAvailable(false);
			parkingSlotRepo.save(parking);
		} else {
			throw new ParkingSlotException("ParkingSlot is not available");
		}
		return parkingSlotDto;
	}

	@Override
	public ParkingSlotDto unParkVehicle(int slotId) {
		Optional<ParkingSlotModel> unparking = parkingSlotRepo.findById(slotId);
		if (unparking.isPresent()) {
			ParkingSlotModel parking = unparking.get();
			parking.setSlotAvailable(true);
			parking.setExitTime(LocalDateTime.now());
			parkingSlotRepo.save(parking);
			ParkingSlotDto parkingSlotDto = modelMapper.map(parking, ParkingSlotDto.class);
			return parkingSlotDto;
		} else {
			throw new ParkingSlotException("ParkingSlot is not available");
		}
	}
}
