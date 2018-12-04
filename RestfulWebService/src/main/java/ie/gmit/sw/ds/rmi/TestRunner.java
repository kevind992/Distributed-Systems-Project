package ie.gmit.sw.ds.rmi;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import ie.gmit.sw.ds.models.Cars;
import ie.gmit.sw.ds.models.Rentals;

public class TestRunner {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		RMI_Client rmiTest = new RMI_Client();

		Rentals r = new Rentals();
		
		r = rmiTest.getAllCars();
		
		for (Cars c : r.getCars()) {
			System.out.println(c.getCarMake() + " " + c.getCarModel());
		}
	}
}
