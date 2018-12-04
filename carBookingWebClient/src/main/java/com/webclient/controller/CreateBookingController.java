package com.webclient.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webclient.marshaller.HTTP_Requests;
import com.webclient.models.Cars;
import com.webclient.models.Rentals;

@Controller
public class CreateBookingController {

	@RequestMapping("/createbooking")
	public String index() {
		return "createbooking";
	}

	// When the user selects new User (Get Request)
	@RequestMapping(value = "/existingUser", method = RequestMethod.GET)
	public String addRentalGET(Model model) {
		
		String dispCar;
		
		Rentals rentals = new Rentals();
		
		model.addAttribute("rentals", rentals);
		
		ArrayList<Cars> cars = (ArrayList<Cars>) new HTTP_Requests().getAllCars().getCars();
		Map<Integer,String> mapCars = new LinkedHashMap<Integer,String>();	
		
		for(int i = 0; i < cars.size(); i++) {
			dispCar = cars.get(i).getCarMake() + " " + cars.get(i).getCarModel();
			//System.out.println(dispCar);
			mapCars.put(cars.get(i).getRentalId(), dispCar);
		}
		
		model.addAttribute("carList",mapCars);
		
		return "existingUser";
	}

	// When the user submits the form (Post Request)
	@RequestMapping(value = "/existingUser", method = RequestMethod.POST)
	public String addRentalPOST(@Valid @ModelAttribute("rentals") Rentals rentals, BindingResult result, Model model) {
		// If there is an error
		if (result.hasErrors()) {
			// Return createAccount.jsp and display the errors
			return "createAccount";
		} else {
			//sent the new rental to the jersey application
			//new HTTP_Requests().createAccount(rentals);
			System.out.println("Rental created..");
			// return showShips.jsp
			return "redirect:/";
		}
	}

	// When the user selects new User (Get Request)
	@RequestMapping(value = "/createAccount", method = RequestMethod.GET)
	public String addAccountGET(Model model) {
		Rentals rentals = new Rentals();
		model.addAttribute("rentals", rentals);
		return "createAccount";
	}

	// When the user submits the form (Post Request)
	@RequestMapping(value = "/createAccount", method = RequestMethod.POST)
	public String addAccountPOST(@Valid @ModelAttribute("rentals") Rentals rentals, BindingResult result, Model model) {
		// If there is an error
		if (result.hasErrors()) {
			// Return createAccount.jsp and display the errors
			return "createAccount";
		} else {
			// Save the new ship to the database
			new HTTP_Requests().createAccount(rentals);
			System.out.println("Account created..");
			// return showShips.jsp
			return "redirect:existingUser";
		}
	}
}
