package com.webclient.controller;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.webclient.models.Accounts;
import com.webclient.models.Rentals;

@RestController
public class CreateBookingController {

	private static final String REST_URI = "http://localhost:8080/RestfulWebService/webapi/createbooking/1001";

	private Client client = ClientBuilder.newClient();

	@GetMapping("/createbooking")
    @ResponseBody
	public Rentals createBooking() {

		return client.target(REST_URI).request(MediaType.APPLICATION_XML).get(Rentals.class);
	}

}
