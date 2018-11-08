package com.webclient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManageBookingController {

	@RequestMapping(value = "/manageBooking", method = RequestMethod.GET)
	public String manageBooking() {
		
		return "manageBooking";
	}
	
}
