package com.webclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webclient.http.HTTP_Requests;

@Controller
public class ViewAllController {

	
	// When the user selects new User (Get Request)
		@RequestMapping(value = "/viewAllRentals", method = RequestMethod.GET)
		public String viewAllRentals(Model model) {
			
			new HTTP_Requests().getAllRentals();
			
			return "viewAllRentals";
		}
	
	
}
