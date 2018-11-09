package com.webclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.webclient.marshaller.HTTP_Requests;

@Controller
public class CreateBookingController {

	@GetMapping("/createbooking")
	public String createBooking() {

		new HTTP_Requests().getRentals();
		
		return "createbooking";
	}
}
