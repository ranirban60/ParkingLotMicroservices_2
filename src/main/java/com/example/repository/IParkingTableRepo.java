package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.model.ParkingTable;

@Repository
public interface IParkingTableRepo extends JpaRepository<ParkingTable, Integer>{
	
	public List<ParkingTable> findBySlotAvailable(boolean isAvailable);
}
