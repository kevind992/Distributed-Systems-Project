package ie.gmit.sw.ds.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import ie.gmit.sw.ds.db.mySQL_DAO;
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
	public void createAccount(Rentals a) throws RemoteException{
			
		String sqlInsert = "insert into accounts "
				+ "values ('" + a.getAccounts().getAccNo() + "','" + a.getAccounts().getFname() + "','"
				+ a.getAccounts().getSurname() + "','" + a.getAccounts().getDob() + "','"
				+ a.getAccounts().getAddress() + "');";
		
		new mySQL_DAO().updateDB(sqlInsert);

	}

	@Override
	public Rentals getAllCars() throws RemoteException {
		return new mySQL_DAO().getCars();
	}

	@Override
	public void createRental(Rentals rental) throws RemoteException {
		
		String sqlInsert = "insert into rentals " // need a space
				+ "values ('46','" + rental.getCars().get(0).getRentalId() + "','" 
				+ rental.getAccounts().getAccNo() + "','"
				+ rental.getRentalDate() + "','" + rental.getReturnDate() + "');";
		
		new mySQL_DAO().updateDB(sqlInsert);
	}

	@Override
	public void updateCar(Rentals toChange) throws RemoteException {
		
		String strUpdate = "update rentals set rental_id = '" + toChange.getCars().get(0).getRentalId() + 
				"' where acc_no like '" + toChange.getAccounts().getAccNo() + "';";
		
		new mySQL_DAO().updateDB(strUpdate);
	}

	@Override
	public void updateRentalDate(Rentals toChange) throws RemoteException {
		
		String strUpdate = "update rentals set rental_date = '" + toChange.getRentalDate() + 
				"' where acc_no like '" + toChange.getAccounts().getAccNo() + "';";
		
		new mySQL_DAO().updateDB(strUpdate);
	}

	@Override
	public void updateReturnDate(Rentals toChange) throws RemoteException {
		
		String strUpdate = "update rentals set return_date = '" + toChange.getReturnDate() + 
				"' where acc_no like '" + toChange.getAccounts().getAccNo() + "';";
		
		new mySQL_DAO().updateDB(strUpdate);
		
	}
}
