package ie.gmit.sw.ds.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import ie.gmit.sw.ds.models.Accounts;


public interface CarBookingServer extends Remote{

	public ArrayList<Accounts> getFileNames() throws RemoteException;
	
}

