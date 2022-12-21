package com.example.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ParkingSlotDto;
import com.example.model.ParkingSlotModel;
import com.example.service.IParkingSlotService;

@RestController
public class ParkingController {

	@Autowired
	IParkingSlotService parkingService;

	@GetMapping("/info")
	public List<ParkingSlotModel> getAvailableSlot() {
    return parkingService.checkSpecificParkingSlotIsAvailable();
	}
	
	@GetMapping("/doPark")
	public ParkingSlotDto parkVehicle(@RequestBody ParkingSlotDto parkingSlotDto) {
		return parkingService.doParkVehicle(parkingSlotDto);
	}
	
	@GetMapping("/unPark/{slotId}")
	public ParkingSlotDto unparkVehicle(@PathVariable int slotId) {
		return parkingService.unParkVehicle(slotId);
	}
	

}
