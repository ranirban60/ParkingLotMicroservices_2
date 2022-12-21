package com.example.service;

import java.util.List;

import com.example.dto.ParkingSlotDto;
import com.example.model.ParkingSlotModel;

public interface IParkingSlotService {
	
	public List<ParkingSlotModel> checkSpecificParkingSlotIsAvailable();

	public ParkingSlotDto doParkVehicle(ParkingSlotDto parkingSlotDto);

	public ParkingSlotDto unParkVehicle(int slotId);

}
