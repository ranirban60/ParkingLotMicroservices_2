package com.example.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.ParkingSlotModel;

@Repository
public interface IParkingSlotRepo extends JpaRepository<ParkingSlotModel, Integer> {

	public List<ParkingSlotModel> findBySlotAvailable(boolean isAvailable);

}
