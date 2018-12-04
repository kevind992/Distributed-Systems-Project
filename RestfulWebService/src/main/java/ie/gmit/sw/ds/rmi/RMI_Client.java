package ie.gmit.sw.ds.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import ie.gmit.sw.ds.models.Rentals;

public class RMI_Client {
	
	private CarBookingServer cbs;
	
	public RMI_Client() throws MalformedURLException, RemoteException, NotBoundException{
		cbs = (CarBookingServer) Naming.lookup("rmi://127.0.0.1:1099/databaseservice");
		System.out.println("Connected..");
		
	}

	public ArrayList<Rentals> getData() throws RemoteException {
 
		ArrayList<Rentals> rentals = cbs.getRentals();

		System.out.println("Array List filled..");

		return rentals;
	}
	
	public Boolean createAccount(Rentals rentals) throws RemoteException {
		
		Boolean check = cbs.createAccount(rentals);
		
		return check;
	}
	
	public Rentals getAllCars() throws RemoteException{
		return cbs.getAllCars();
	}
}
