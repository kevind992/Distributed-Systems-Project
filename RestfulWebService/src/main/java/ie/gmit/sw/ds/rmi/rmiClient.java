package ie.gmit.sw.ds.rmi;

import java.rmi.Naming;
import java.util.ArrayList;

import ie.gmit.sw.ds.models.Accounts;

public class rmiClient {

	public ArrayList<Accounts> getData() throws Exception{

		CarBookingServer cbs = (CarBookingServer) Naming.lookup("rmi://127.0.0.1:1099/carbooking2");
		System.out.println("Connected..");

		ArrayList<Accounts> acc = cbs.getFileNames();

		System.out.println("Array List filled..");

		return acc;
	}

}
