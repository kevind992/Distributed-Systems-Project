package ie.gmit.sw.ds.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import ie.gmit.sw.ds.models.Rentals;

public interface DatabaseService extends Remote{

	public ArrayList<Rentals> getRentals() throws RemoteException;
	
	public ArrayList<String> getAccNum() throws RemoteException;
	
	public void createAccount(Rentals rentals) throws RemoteException;
	
	public Rentals getAllCars() throws RemoteException;
	
	public boolean createRental(Rentals rental) throws RemoteException;
	
	public boolean updateCar(Rentals toChange) throws RemoteException;
	
	public boolean updateRentalDate(Rentals toChange) throws RemoteException;
	
	public boolean updateReturnDate(Rentals toChange) throws RemoteException;
	
	public boolean deleteRental(String value) throws RemoteException;
	
}
