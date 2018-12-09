package ie.gmit.sw.ds.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import ie.gmit.sw.ds.db.mySQL_DAO;
import ie.gmit.sw.ds.models.Rentals;

public class DatabaseServiceImpl extends UnicastRemoteObject implements DatabaseService {

	private static final long serialVersionUID = 1L;

	public DatabaseServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public ArrayList<Rentals> getRentals() throws RemoteException {
		return new mySQL_DAO().getRental();
	}
	
	@Override
	public ArrayList<String> getAccNum() throws RemoteException {
		
		return new mySQL_DAO().getAccounts();
	}

	@Override
	public void createAccount(Rentals a) throws RemoteException {

		String sqlInsert = "insert into accounts " + "values ('" + a.getAccounts().getAccNo() + "','"
				+ a.getAccounts().getFname() + "','" + a.getAccounts().getSurname() + "','" + a.getAccounts().getDob()
				+ "','" + a.getAccounts().getAddress() + "');";

		new mySQL_DAO().updateDB(sqlInsert);

	}

	@Override
	public Rentals getAllCars() throws RemoteException {
		return new mySQL_DAO().getCars();
	}

	@Override
	public boolean createRental(Rentals rental) throws RemoteException {

		ArrayList<Integer> idList = new mySQL_DAO().getRentalId();
		
		int id = idList.get(idList.size()-1);
		id++;
		
		String sqlInsert = "insert into rentals " // need a space
				+ "values ('"+ id + "','" + rental.getCars().get(0).getRentalId() + "','" + rental.getAccounts().getAccNo()
				+ "','" + rental.getRentalDate() + "','" + rental.getReturnDate() + "');";

		return new mySQL_DAO().updateDB(sqlInsert);
	}

	@Override
	public void updateCar(Rentals toChange) throws RemoteException {

		String strUpdate = "update rentals set rental_id = '" + toChange.getCars().get(0).getRentalId()
				+ "' where acc_no like '" + toChange.getAccounts().getAccNo() + "';";

		new mySQL_DAO().updateDB(strUpdate);
	}

	@Override
	public void updateRentalDate(Rentals toChange) throws RemoteException {

		String strUpdate = "update rentals set rental_date = '" + toChange.getRentalDate() + "' where acc_no like '"
				+ toChange.getAccounts().getAccNo() + "';";

		new mySQL_DAO().updateDB(strUpdate);
	}

	@Override
	public void updateReturnDate(Rentals toChange) throws RemoteException {

		String strUpdate = "update rentals set return_date = '" + toChange.getReturnDate() + "' where acc_no like '"
				+ toChange.getAccounts().getAccNo() + "';";

		new mySQL_DAO().updateDB(strUpdate);

	}

	@Override
	public void deleteRental(String value) throws RemoteException {

		String sqlDelete = "delete from rentals where acc_no like '" + value + "';";

		new mySQL_DAO().updateDB(sqlDelete);
	}
}
