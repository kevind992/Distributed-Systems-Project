package ie.gmit.sw.ds.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import ie.gmit.sw.ds.models.Rentals;

public class RMI_Client {
	
	private DatabaseService cbs;
	
	public RMI_Client() throws MalformedURLException, RemoteException, NotBoundException{
		cbs = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/databaseservice");
		System.out.println("Connected..");
	}

	public ArrayList<Rentals> getData() throws RemoteException {
		return cbs.getRentals();
	}
	
	public ArrayList<String> getAccNum() throws RemoteException {
		return cbs.getAccNum();
	}
	
	public void createAccount(Rentals rentals) throws RemoteException {
		cbs.createAccount(rentals);
	}
	
	public Rentals getAllCars() throws RemoteException{
		return cbs.getAllCars();
	}
	
	public boolean createRental(Rentals rental) throws RemoteException{
		return cbs.createRental(rental);
	}

	public boolean updateCar(Rentals toChange) throws RemoteException{
		return cbs.updateCar(toChange);
	}

	public boolean updateRentalDate(Rentals toChange) throws RemoteException{
		return cbs.updateRentalDate(toChange);
	}

	public boolean updateReturnDate(Rentals toChange) throws RemoteException{
		return cbs.updateReturnDate(toChange);
	}

	public boolean deleteRental(String value) throws RemoteException{
		return cbs.deleteRental(value);
	}
}
