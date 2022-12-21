package com.example.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSlotException extends RuntimeException {

	private static final long serialVersionUID = 1L;
   
	String message;
}
