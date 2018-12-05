package ie.gmit.sw.ds.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import ie.gmit.sw.ds.db.mySQL_DAO;
import ie.gmit.sw.ds.models.Accounts;
import ie.gmit.sw.ds.models.Rentals;

public class CarBookingServerImpl extends UnicastRemoteObject implements CarBookingServer {

	private static final long serialVersionUID = 1L;

	public CarBookingServerImpl() throws RemoteException{
		super();
	}
	
	@Override
	public ArrayList<Rentals> getRentals() throws RemoteException {
		 
		 ArrayList<Rentals> acc = new mySQL_DAO().getRental();
		
		return acc;
			
	}
	
	@Override
	public Boolean createAccount(Rentals rentals) throws RemoteException{
			
		Boolean response = new mySQL_DAO().createAccount(rentals);
		
		if(response) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Rentals getAllCars() throws RemoteException {
		return new mySQL_DAO().getCars();
	}

	@Override
	public void createRental(Rentals rental) throws RemoteException {
		// TODO Auto-generated method stub
		new mySQL_DAO().createRental(rental);
	}

	@Override
	public void updateCar(Rentals toChange) throws RemoteException {
		new mySQL_DAO().updateCar(toChange);
	}
}
