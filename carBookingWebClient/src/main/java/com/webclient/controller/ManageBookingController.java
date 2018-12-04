package com.webclient.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webclient.marshaller.HTTP_Requests;
import com.webclient.models.Rentals;

@Controller
public class ManageBookingController {

	private String account;
	
	// When the user selects new User (Get Request)
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String manageBookingGet(Model model) {

		System.out.println("Here..");
		Rentals rentals = new Rentals();

		model.addAttribute("rentals", rentals);

		return "searchAccount";
	}

	// When the user submits the form (Post Request)
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchAccountPOST(@Valid @ModelAttribute("rentals") Rentals rentals, BindingResult result, Model model) {
		
		Rentals response = new HTTP_Requests().getRentals(rentals.getAccounts().getAccNo());
		
		// If there is an error
		if (result.hasErrors()) {
			// Return createAccount.jsp and display the errors
			return "searchAccount";
		} else {
			// Save the new ship to the database
			System.out.println("Account found..");
			account = response.getAccounts().getAccNo() + " " + response.getAccounts().getFname() + " " + response.getAccounts().getSurname() +
					response.getCars().get(0).getCarMake() + " " + response.getCars().get(0).getCarModel() + " " + response.getRentalDate() 
					+ " " + response.getReturnDate();
			System.out.println(account);
			// return manageBooking.jsp
			return "redirect:manageBooking";
		}
	}

}
