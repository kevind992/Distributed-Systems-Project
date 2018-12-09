package com.webclient.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.webclient.http.HTTP_Requests;
import com.webclient.models.Rentals;

@Controller
public class ViewAllController {

	
	// When the user selects new User (Get Request)
		@RequestMapping(value = "/viewAllRentals", method = RequestMethod.GET)
		public String viewAllRentals(Model model) {
			
			String disp;
			
			ArrayList<Rentals> listRentals = (ArrayList<Rentals>) new HTTP_Requests().getAllRentals();
			
			//List<Rentals> rentals = new HTTP_Requests().getAllRentals();
			
			model.addAttribute("rentals", listRentals);
			
			return "viewAllRentals";
		}
	
	
}
