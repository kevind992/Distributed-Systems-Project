package ie.gmit.sw.ds.RestfulWebService;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.inject.Singleton;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import ie.gmit.sw.ds.models.Rentals;
import ie.gmit.sw.ds.rmi.RMI_Client;

@Singleton
@Path("/manage")
public class ManageRental implements ManageRentalInterface {

	public Response updateCar(Rentals toChange) throws RemoteException, MalformedURLException, NotBoundException {
		System.out.println("Putting......");
		boolean check = new RMI_Client().updateCar(toChange);

		if (check) {
			String msg = "Car was Updated";
			return Response.status(200).entity(msg).build();
		} else {
			String msg = "Car was Not Updated";
			return Response.status(404).entity(msg).build();
		}	
	}

	@Override
	public Response updateRentalDate(Rentals toChange)
			throws RemoteException, MalformedURLException, NotBoundException {
		boolean check = new RMI_Client().updateRentalDate(toChange);

		if (check) {
			String msg = "Rental Date was Updated";
			return Response.status(200).entity(msg).build();
		} else {
			String msg = "Rental Date was Not Updated";
			return Response.status(404).entity(msg).build();
		}
	}

	@Override
	public Response updateReturnDate(Rentals toChange)
			throws RemoteException, MalformedURLException, NotBoundException {
		boolean check = new RMI_Client().updateReturnDate(toChange);

		if (check) {
			String msg = "Return Date was Updated";
			return Response.status(200).entity(msg).build();
		} else {
			String msg = "Return Date was Not Updated";
			return Response.status(404).entity(msg).build();
		}
	}

	@Override
	public Response deleteRental(String value) throws RemoteException, MalformedURLException, NotBoundException {

		boolean check = new RMI_Client().deleteRental(value);

		if (check) {

			String msg = "The Order Number " + value + " was Deleted!";
			return Response.status(200).entity(msg).build();
			
		} else {
			String msg = "The Order Number " + value + " was NOT Deleted!";
			return Response.status(404).entity(msg).build();
		}

		
	}
}
