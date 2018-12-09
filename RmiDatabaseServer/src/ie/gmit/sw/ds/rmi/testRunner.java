package ie.gmit.sw.ds.rmi;

import java.rmi.RemoteException;

import ie.gmit.sw.ds.db.mySQL_DAO;
import ie.gmit.sw.ds.models.Rentals;
import ie.gmit.sw.ds.models.Cars;

public class testRunner {
	
	public static void main(String[] args) throws RemoteException {
		
		Rentals r = new Rentals();
		
		r = new mySQL_DAO().getCars();
		
		for (Cars c : r.getCars()) {
			System.out.println(c.getCarMake() + " " + c.getCarModel());
		}
	}
}
