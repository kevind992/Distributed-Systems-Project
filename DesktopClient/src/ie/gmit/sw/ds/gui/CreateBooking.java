package ie.gmit.sw.ds.gui;

import java.util.ArrayList;
import java.util.Scanner;
import ie.gmit.sw.ds.http.HTTP_Requests;
import ie.gmit.sw.ds.models.Accounts;
import ie.gmit.sw.ds.models.Cars;
import ie.gmit.sw.ds.models.Rentals;

public class CreateBooking {

	private Scanner stdin;
	
	public void Option() {
		
		int option = 0;
		stdin = new Scanner(System.in);
		
		do {
			// Diplaying options to the user
			System.out.println("Select an Option");
			System.out.println("======================================");
			System.out.println("Select '1' if you are a New User\nSelect '2' if you are an Existing User\nSelect '0' to Exit");
			System.out.println("======================================");
			// Getting user input
			option = stdin.nextInt();

			switch (option) {
			case 1:
				newUser();
				break;
			case 2:
				existingUser();
				break;
			default:
				break;
			}
			
		}while(option!=0);
		
	}
	// New user method
	private void newUser() {
		
		Rentals rental = new Rentals();
		Accounts acc = new Accounts();
		stdin = new Scanner(System.in);
		
		// Getting user details to fill account
		System.out.println("======================================");
		System.out.println("Create Account");
		System.out.println("======================================");
		System.out.println("Enter a Account Num: ");
		acc.setAccNo(stdin.nextLine());
		System.out.println("Enter a First Name: ");
		acc.setFname(stdin.nextLine());
		System.out.println("Enter a Surname: ");
		acc.setSurname(stdin.nextLine());
		System.out.println("Enter a DOB (YYYY/mm/DD)");
		acc.setDob(stdin.nextLine());
		System.out.println("Enter a Address:");
		acc.setAddress(stdin.nextLine());
		
		rental.setAccounts(acc);
		
		// Sending the New Account to be created and getting a response
		boolean check = new HTTP_Requests().createAccount(rental);
		
		// if response is true then account is created otherwise account was not created
		if(check) {
			System.out.println("Account Created..");
		}else {
			System.out.println("Account Not Created..");
		}
		
	}
	
	private void existingUser() {
		
		Rentals rental = new Rentals();
		Accounts acc = new Accounts();
		Cars car = new Cars();
		stdin = new Scanner(System.in);
		
		// Getting all the car in the db
		ArrayList<Cars> cars = (ArrayList<Cars>) new HTTP_Requests().getAllCars().getCars();
		
		// Showing options to the user
		System.out.println("======================================");
		System.out.println("Create Rental");
		System.out.println("======================================");
		// Asking user for rental details
		System.out.println("Enter Account Num: ");
		acc.setAccNo(stdin.nextLine());
		System.out.println("Enter Hire Date (YYYY/mm/DD): ");
		rental.setRentalDate(stdin.nextLine());
		System.out.println("Enter Return Date (YYYY/mm/DD): ");
		rental.setReturnDate(stdin.nextLine());
		System.out.println("Please enter selected Car Id:");
		
		// displaying available cars
		System.out.println("======================================");
		System.out.println("Rental ID  |  Make   |   Model   |   Trans   |   Fuel   |");
		System.out.println("======================================");
		for (Cars c : cars) {
			System.out.println(c.getRentalId() + "     " + c.getCarMake() + "     " + c.getCarModel() + "     " +
					c.getTransmission() + "     " + c.getFuelType());
		}
		System.out.println("======================================");
		// asking user for selected car
		car.setRentalId(stdin.nextInt());
		
		
		rental.setAccounts(acc);
		rental.getCars().add(car);
		
		// sending rentals and getting response
		boolean check = new HTTP_Requests().createRental(rental);

		// if response is true rental has been created if false rental has not been created.
		if (check) {
			System.out.println("Rental Created");
		} else {
			System.out.println("Rental Not Created");
		}
	}
	
}
