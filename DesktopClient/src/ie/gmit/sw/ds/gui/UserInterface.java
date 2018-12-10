package ie.gmit.sw.ds.gui;

import java.util.*;

public class UserInterface {

	private Scanner stdin;

	public void options() {

		int option = 0;
		stdin = new Scanner(System.in);

		// Header
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.println("Car Rental Booking System");
		System.out.println("++++++++++++++++++++++++++++++++++++++\n");

		do {
			// Showing options to the user
			System.out.println("Select an Option");
			System.out.println("======================================");
			System.out.println(
					"Select '1' if you wish to Create a Booking\nSelect '2' if you wish to Manage a Booking\nSelect '0' to Exit");
			System.out.println("======================================");
			// getting option from the user
			option = stdin.nextInt();

			switch (option) {
			case 1:
				new CreateBooking().Option();
				break;
			case 2:
				new ManageRental().FindAccount();
				break;
			default:
				break;
			}
			// keep looping while not option is not 0
		} while (option != 0);

	}

}
