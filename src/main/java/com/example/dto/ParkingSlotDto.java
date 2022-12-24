package com.example.dto;

import java.time.LocalDateTime;

import com.example.model.ParkingTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSlotDto {
    
	//private int slotNumber;
	private String carRegNum;
	private String carName;
	private String carOwnerName;
	private LocalDateTime entryTime;
	private LocalDateTime exitTime;
	public ParkingTable slotId;
}
