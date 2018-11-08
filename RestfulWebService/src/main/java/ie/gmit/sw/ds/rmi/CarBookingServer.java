package ie.gmit.sw.ds.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import ie.gmit.sw.ds.models.Accounts;
import ie.gmit.sw.ds.models.Rentals;


public interface CarBookingServer extends Remote{

	public ArrayList<Rentals> getRentals() throws RemoteException;
	
}

