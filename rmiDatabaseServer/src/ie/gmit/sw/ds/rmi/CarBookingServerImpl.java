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
		
		ArrayList<Rentals> acc = new ArrayList<>();
		
		acc = new mySQL_DAO().getRental();
		
		return acc;
			
	}
}
