package com.example.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "parkingSlot")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSlotModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int slotNumber;
	private String carRegNum;
	private String carName;
	private String carOwnerName;
	private LocalDateTime entryTime;
	private LocalDateTime exitTime;
	private Double fare;
	
	@JoinColumn(name="slotId")
	@OneToOne(cascade = CascadeType.ALL)
	public ParkingTable slotId;
	
	
	
}
