package ie.gmit.sw.ds.gui;

import java.util.*;

public class UserInterface {

	private Scanner stdin;

	public void options() {

		int option = 0;
		stdin = new Scanner(System.in);

		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.println("Car Rental Booking System");
		System.out.println("++++++++++++++++++++++++++++++++++++++\n");

		do {

			System.out.println("Select an Option");
			System.out.println("======================================");
			System.out.println(
					"Select '1' if you wish to Create a Booking\nSelect '2' if you wish to Manage a Booking\nSelect '0' to Exit");
			System.out.println("======================================");
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

		} while (option != 0);

	}

}
