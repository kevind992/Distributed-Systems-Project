package ie.gmit.sw.ds.rmi;

import java.rmi.Naming;
import java.util.ArrayList;

import ie.gmit.sw.ds.models.Accounts;
import ie.gmit.sw.ds.models.Rentals;

public class rmiClient {

	public ArrayList<Rentals> getData() throws Exception{

		CarBookingServer cbs = (CarBookingServer) Naming.lookup("rmi://127.0.0.1:1099/databaseservice");
		System.out.println("Connected..");

		ArrayList<Rentals> rentals = cbs.getRentals();

		System.out.println("Array List filled..");

		return rentals;
	}

}
