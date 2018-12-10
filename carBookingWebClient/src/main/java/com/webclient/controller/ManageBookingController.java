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

import com.webclient.http.HTTP_Requests;
import com.webclient.models.Accounts;
import com.webclient.models.Cars;
import com.webclient.models.Rentals;

@Controller
public class ManageBookingController {

	private Rentals response = new Rentals();
	private String searchAcc;

	// When the user selects new User (Get Request)
	@RequestMapping(value = "/searchAccount", method = RequestMethod.GET)
	public String manageBookingGet(Model model) {

		Rentals rentals = new Rentals();

		model.addAttribute("rentals", rentals);

		return "searchAccount";
	}

	// When the user submits the form (Post Request)
	@RequestMapping(value = "/searchAccount", method = RequestMethod.POST)
	public String searchAccountPOST(@Valid @ModelAttribute("rentals") Rentals rentals, Model model) {

		searchAcc = rentals.getAccounts().getAccNo();
		response = new HTTP_Requests().getRentals(searchAcc);

		if (response == null) {
			model.addAttribute("accNo", searchAcc);
			// Return createAccount.jsp and display the errors
			System.out.println("Has Errors..");
			return "accountError";

		} else {

			// Save the new ship to the database
			System.out.println("Account found..");

			model.addAttribute("rental", response);

			System.out.println("Displaying rentals..");

			// return manageBooking.jsp
			return "manageBooking";
		}
	}

	// When the user selects update in the car section (Get Request)
	@RequestMapping(value = "/updateCar", method = RequestMethod.GET)
	public String manageUpdateCarGet(Model model) {

		String dispCar;

		Rentals rentals = new Rentals();

		model.addAttribute("rentals", rentals);

		System.out.println("Updating Car..");

		ArrayList<Cars> cars = (ArrayList<Cars>) new HTTP_Requests().getAllCars().getCars();
		Map<Integer, String> mapCars = new LinkedHashMap<Integer, String>();

		for (int i = 0; i < cars.size(); i++) {
			dispCar = cars.get(i).getCarMake() + " " + cars.get(i).getCarModel();
			// System.out.println(dispCar);
			mapCars.put(cars.get(i).getRentalId(), dispCar);
		}

		model.addAttribute("carList", mapCars);

		return "updateCar";
	}

	// When the user submits the form (Post Request)
	@RequestMapping(value = "/updateCar", method = RequestMethod.POST)
	public String manageUpdateCarPOST(@Valid @ModelAttribute("rentals") Rentals rentals, Model model) {
		
		Accounts acc = new Accounts();
		acc.setAccNo(response.getAccounts().getAccNo());
		rentals.setAccounts(acc);

		// sent the new rental to the jersey application
		boolean check = new HTTP_Requests().updateCar(rentals);
		if(check) {
			System.out.println("Car Rental Updated..");
			model.addAttribute("rental", response);
			return "manageBooking";
		}else {
			return "accountError";
		}
	}

	// When the user selects update in the car section (Get Request)
	@RequestMapping(value = "/updateRentalDate", method = RequestMethod.GET)
	public String updateRentalDatePOST(Model model) {

		System.out.println("Updating Rental Date..");
		Rentals rentals = new Rentals();

		model.addAttribute("rentals", rentals);

		return "updateRentalDate";
	}

	// When the user submits the form (Post Request)
	@RequestMapping(value = "/updateRentalDate", method = RequestMethod.POST)
	public String updateRentalDatePOST(@Valid @ModelAttribute("rentals") Rentals rentals, Model model) {
		
		Accounts acc = new Accounts();
		acc.setAccNo(response.getAccounts().getAccNo());
		rentals.setAccounts(acc);

		// sent the new rental to the jersey application
		boolean check = new HTTP_Requests().updateRentalDate(rentals);
		if(check) {
			System.out.println("Car Rental Date Updated..");
			model.addAttribute("rentals", response);
			return "manageBooking";
		}else {
			return "accountError";
		}
	}

	// When the user selects update in the car section (Get Request)
	@RequestMapping(value = "/updateReturnDate", method = RequestMethod.GET)
	public String manageUpdateReturnGet(Model model) {

		System.out.println("Updating Return Date..");
		Rentals rentals = new Rentals();

		model.addAttribute("rentals", rentals);

		return "updateReturnDate";
	}

	// When the user submits the form (Post Request)
	@RequestMapping(value = "/updateReturnDate", method = RequestMethod.POST)
	public String manageUpdateReturnPost(@Valid @ModelAttribute("rentals") Rentals rentals,
			Model model) {
		
		Accounts acc = new Accounts();
		acc.setAccNo(response.getAccounts().getAccNo());
		rentals.setAccounts(acc);
		// sent the new rental to the jersey application
		boolean check = new HTTP_Requests().updateReturnDate(rentals);
		
		// depending on response return jsp file
		if(check) {
			System.out.println("Car Rental Date Updated..");
			model.addAttribute("rentals", response);
			return "manageBooking";
		}else {
			return "accountError";
		}
		
		
	}
	// Method for sending the selected item for deletion
	@RequestMapping(value = "/rentalDeleted", method = RequestMethod.GET)
	public String deleteRental() {

		// sending the rental object to rest server and getting a boolean response
		boolean check = new HTTP_Requests().deleteRental(response);
		
		//depending on response return jsp page
		if(check) {
			return "rentalDeleted";
		}else {
			return "accountError";
		}
		
	}

}
