package com.example.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ParkingSlotDto;
import com.example.model.ParkingSlotModel;
import com.example.model.ParkingTable;
import com.example.service.IParkingSlotService;

@RestController
@RequestMapping("/parkingSlot")
public class ParkingController {

	@Autowired
	IParkingSlotService parkingService;

	@GetMapping("/info")
	public List<ParkingSlotModel> getInfo() {
    return parkingService.getInfo();
	}
	
	@GetMapping("/doPark")
	public ParkingSlotDto parkVehicle(@RequestBody ParkingSlotDto parkingSlotDto) {
		return parkingService.doParkVehicle(parkingSlotDto);
	}
	
	@GetMapping("/unPark/{slotNumber}")
	public ParkingSlotDto unparkVehicle(@PathVariable int slotNumber) {
		return parkingService.unParkVehicle(slotNumber);
	}
	
	@GetMapping("/getSlot")
	public List<ParkingTable> getSlot(){
		return parkingService.checkSlot();
	}

}
