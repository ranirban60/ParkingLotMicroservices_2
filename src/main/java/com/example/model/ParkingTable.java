package com.example.model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ParkingTable {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int slotId;
	public boolean slotAvailable=true;
	
	
}
