package ie.gmit.sw.ds.db;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ie.gmit.sw.ds.models.Rentals;

public interface mySQLDAOInterface {
	public ArrayList<Rentals> getRental() throws RemoteException;
}
