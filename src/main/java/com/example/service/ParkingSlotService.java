package com.example.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dto.ParkingSlotDto;
import com.example.exception.ParkingSlotException;
import com.example.model.ParkingSlotModel;
import com.example.model.ParkingTable;
import com.example.repository.IParkingSlotRepo;
import com.example.repository.IParkingTableRepo;

@Service
public class ParkingSlotService implements IParkingSlotService {

	@Autowired
	IParkingSlotRepo parkingSlotRepo;

	@Autowired
	IParkingTableRepo parkingTableRepo;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public List<ParkingSlotModel> getInfo() {

		List<ParkingSlotModel> parkingSlot = parkingSlotRepo.findAll();
		if (parkingSlot.isEmpty()) {
			throw new ParkingSlotException("ParkingSlot is available");
		} else
			return parkingSlot;

	}

	@Override
	public ParkingSlotDto doParkVehicle(ParkingSlotDto parkingSlotDto) {

		ParkingSlotModel parking = modelMapper.map(parkingSlotDto, ParkingSlotModel.class);
//		int number = parkingSlotRepo.findBySlotAvailable(true).size();
		int number = parkingTableRepo.findBySlotAvailable(false).size();
		System.out.println(number);
		System.out.println(parking.slotId.slotId);
		if (number <= 20) {
			parking.setEntryTime(LocalDateTime.now());
			parkingSlotRepo.save(parking);
			ParkingTable park = parkingTableRepo.findById(parking.slotId.slotId).get();
			park.setSlotAvailable(false);
			parkingTableRepo.save(park);

		} else {
			throw new ParkingSlotException("ParkingSlot is not available");
		}
		parkingSlotDto.setEntryTime(LocalDateTime.now());
		System.out.println(number);
		return parkingSlotDto;
	}

	@Override
	public ParkingSlotDto unParkVehicle(int slotNumber) {
		Optional<ParkingSlotModel> parking = parkingSlotRepo.findById(slotNumber);
		if (parking.isPresent()) {
			ParkingSlotModel unparking = parking.get();
			unparking.setExitTime(LocalDateTime.now());
			parkingSlotRepo.save(unparking);
			ParkingTable park = parkingTableRepo.findById(parking.get().slotId.slotId).get();
			park.setSlotAvailable(true);
			parkingTableRepo.save(park);
			ParkingSlotDto parkingSlotDto = modelMapper.map(unparking, ParkingSlotDto.class);
			return parkingSlotDto;
		} else {
			throw new ParkingSlotException("ParkingSlot is not available");
		}
	}

	@Override
	public List<ParkingTable> checkSlot() {
		// ParkingSlotModel parking = modelMapper.map(parkingSlotRepo,
		// ParkingSlotModel.class);

		// return parkingTableRepo.findAll().stream().map(parking ->
		// modelMapper.map(parking, ParkingTable.class))
		// .collect(Collectors.toList());
//		long number = parkingTableRepo.count();
//		if (number <= 20) {
		return parkingTableRepo.findAll().stream().map(parking -> modelMapper.map(parking, ParkingTable.class))
				.collect(Collectors.toList());
//			parking.get().setSlotAvailable(true);
//			parking.get().getSlotId();
//			parking.get().getSlotNumber();
//			parkingSlotRepo.save(parking);
//			ParkingTable parkingTable = modelMapper.map(parking, ParkingTable.class);
//			return park;
//		}
//		return null; 
	}
}
