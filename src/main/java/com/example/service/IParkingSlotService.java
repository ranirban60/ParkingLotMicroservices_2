package com.example.service;

import java.util.List;

import com.example.dto.ParkingSlotDto;
import com.example.model.ParkingSlotModel;
import com.example.model.ParkingTable;

public interface IParkingSlotService {
	
	public List<ParkingSlotModel> getInfo();

	public ParkingSlotDto doParkVehicle(ParkingSlotDto parkingSlotDto);

	public ParkingSlotDto unParkVehicle(int slotNumber);

	public List<ParkingTable> checkSlot();

}
