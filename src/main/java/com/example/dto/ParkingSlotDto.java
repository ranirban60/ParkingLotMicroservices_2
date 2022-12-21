package com.example.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSlotDto {
    
	private int slotId;
	private String carNumber;
	private String carName;
	private String carOwnerName;
	private LocalDateTime entryTime;
	private LocalDateTime exitTime;
	
}
