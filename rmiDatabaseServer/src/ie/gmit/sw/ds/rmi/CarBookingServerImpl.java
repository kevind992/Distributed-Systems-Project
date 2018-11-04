package ie.gmit.sw.ds.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import ie.gmit.sw.ds.db.mySQL_DAO;
import ie.gmit.sw.ds.models.Accounts;

public class CarBookingServerImpl extends UnicastRemoteObject implements CarBookingServer {

	private static final long serialVersionUID = 1L;

	public CarBookingServerImpl() throws RemoteException{
		super();
	}
	
	@Override
	public ArrayList<Accounts> getFileNames() throws RemoteException {
		
		ArrayList<Accounts> acc = new ArrayList<>();
		
		acc = new mySQL_DAO().getAccounts();
		
		return acc;
			
	}

}
