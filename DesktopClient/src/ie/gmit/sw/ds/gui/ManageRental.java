package ie.gmit.sw.ds.gui;

import java.util.ArrayList;
import java.util.Scanner;

import ie.gmit.sw.ds.http.HTTP_Requests;
import ie.gmit.sw.ds.models.Accounts;
import ie.gmit.sw.ds.models.Cars;
import ie.gmit.sw.ds.models.Rentals;

public class ManageRental {

	private Scanner stdin;
	private Rentals response;

	public ManageRental() {
		stdin = new Scanner(System.in);
		response = new Rentals();
	}

	// Method for finding an account
	public void FindAccount() {

		Accounts acc = new Accounts();

		// Displaying options to the user
		System.out.println("======================================");
		System.out.println("Manage Rental");
		System.out.println("======================================");
		System.out.println("Enter Account Number for Rental:");
		String test = stdin.next();
		acc.setAccNo(test);

		// returning account number and saving response into response
		response = new HTTP_Requests().getRentals(acc.getAccNo());

		// if null no account with that account number
		if (response == null) {
			System.out.println("No Account with that Account Number");
		
		} else { // else account found
			System.out.println("Account Found");
			// calling display rental method
			DisplayRental();
		}
	}
	// Method for displaying rentals
	public void DisplayRental() {

		// displaying rentals to the user
		System.out.println("======================================");
		System.out.println("Rental: " + response.getAccounts().getAccNo());
		System.out.println("======================================");
		System.out.println(response.getAccounts().getFname() + " " + response.getAccounts().getSurname() + " | "
				+ response.getCars().get(0).getCarMake() + " " + response.getCars().get(0).getCarModel() + " | "
				+ response.getRentalDate() + " | " + response.getReturnDate());
		System.out.println("======================================");
		// showing the options to the user
		System.out.println("Select an Option: ");
		System.out.println("Select '1' to Update Car\nSelect '2' to Update Rental Date\nSelect '3' to Update Return Date");
		// Getting the option from the usre
		int option = stdin.nextInt();

		switch (option) {
		case 1:
			updateCar();
			break;
		case 2:
			updateRentalDate();
			break;
		case 3:
			updateReturnDate();
			break;
		default:
			System.out.println("Invalid Option");
			break;
		}

	}
	// Update car method
	private void updateCar() {

		ArrayList<Cars> cars = (ArrayList<Cars>) new HTTP_Requests().getAllCars().getCars();
		Cars carUpdate = new Cars();
		Rentals update = new Rentals();

		System.out.println("======================================");
		System.out.println("Update Car");
		System.out.println("======================================");
		System.out.println("Please enter selected Car Id:");
		System.out.println("======================================");
		System.out.println("Rental ID  |  Make   |   Model   |   Trans   |   Fuel   |");
		System.out.println("======================================");
		for (Cars c : cars) {
			System.out.println(c.getRentalId() + "     " + c.getCarMake() + "     " + c.getCarModel() + "     "
					+ c.getTransmission() + "     " + c.getFuelType());
		}
		System.out.println("======================================");
		carUpdate.setRentalId(stdin.nextInt());

		Accounts acc = new Accounts();
		acc.setAccNo(response.getAccounts().getAccNo());
		update.setAccounts(acc);
		update.getCars().add(carUpdate);
	}

	private void updateRentalDate() {

		Rentals update = new Rentals();

		System.out.println("======================================");
		System.out.println("Update Rental Date");
		System.out.println("======================================");
		System.out.println("Enter new Rental Date:");
		update.setRentalDate(stdin.nextLine());

		Accounts acc = new Accounts();
		acc.setAccNo(response.getAccounts().getAccNo());
		update.setAccounts(acc);

		// sent the new rental to the jersey application
		new HTTP_Requests().updateRentalDate(update);

	}
	// Update Return date method
	private void updateReturnDate() {

		Rentals update = new Rentals();

		System.out.println("======================================");
		System.out.println("Update Return Date");
		System.out.println("======================================");
		System.out.println("Enter new Return Date:");
		update.setReturnDate(stdin.nextLine());

		Accounts acc = new Accounts();
		acc.setAccNo(response.getAccounts().getAccNo());
		update.setAccounts(acc);

		// sent the new rental to the jersey application
		new HTTP_Requests().updateReturnDate(update);
	}
}
