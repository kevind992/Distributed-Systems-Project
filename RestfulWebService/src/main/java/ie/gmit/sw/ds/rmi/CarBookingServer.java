package ie.gmit.sw.ds.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import ie.gmit.sw.ds.models.Accounts;
import ie.gmit.sw.ds.models.Rentals;


public interface CarBookingServer extends Remote{

	public ArrayList<Rentals> getRentals() throws RemoteException;
	
	public void createAccount(Rentals rentals) throws RemoteException;
	
	public Rentals getAllCars() throws RemoteException;
	
	public void createRental(Rentals rental) throws RemoteException;
	
	public void updateCar(Rentals toChange) throws RemoteException;
	
	public void updateRentalDate(Rentals toChange) throws RemoteException;
	
	public void updateReturnDate(Rentals toChange) throws RemoteException;
	
	public void deleteRental(String value) throws RemoteException;
	
}

