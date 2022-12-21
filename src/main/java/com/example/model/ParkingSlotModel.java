package com.example.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "parkingSlot")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSlotModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int slotId;
	private String carNumber;
	private String carName;
	private String carOwnerName;
	private LocalDateTime entryTime;
	private LocalDateTime exitTime;
	private Double fare;
	private boolean slotAvailable=true;
	
	
	
}
