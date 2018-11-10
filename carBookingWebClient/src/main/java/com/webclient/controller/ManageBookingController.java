package com.webclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webclient.marshaller.HTTP_Requests;

@RestController
public class ManageBookingController {

	@GetMapping("/manageBooking")
	public String manageBooking() {

		new HTTP_Requests().getRentals();
		
		return "createbooking";
	}
	
}
