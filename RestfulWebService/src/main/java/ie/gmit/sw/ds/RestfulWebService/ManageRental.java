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

	// RESTful method for updating car
	public Response updateCar(Rentals toChange) throws RemoteException, MalformedURLException, NotBoundException {
		
		// Sending rental to be changed to database returning whether it has been changed or not
		boolean check = new RMI_Client().updateCar(toChange);

		// if updated return status 200 otherwise return a 404
		if (check) {
			String msg = "Car was Updated";
			return Response.status(200).entity(msg).build();
		} else {
			String msg = "Car was Not Updated";
			return Response.status(404).entity(msg).build();
		}	
	}
	
	// RESTful method for updating rental date
	@Override
	public Response updateRentalDate(Rentals toChange)
			throws RemoteException, MalformedURLException, NotBoundException {
		
		// Sending rental with updated rental date to database to be updated
		boolean check = new RMI_Client().updateRentalDate(toChange);

		// if successful return status 200 otherwise return 404 
		if (check) {
			String msg = "Rental Date was Updated";
			return Response.status(200).entity(msg).build();
		} else {
			String msg = "Rental Date was Not Updated";
			return Response.status(404).entity(msg).build();
		}
	}
	
	// RESTful method for updating Return date
	@Override
	public Response updateReturnDate(Rentals toChange)
			throws RemoteException, MalformedURLException, NotBoundException {
		
		// Sending rental with updated return date to database to be updated
		boolean check = new RMI_Client().updateReturnDate(toChange);

		// if successful return status 200 otherwise return 404 
		if (check) {
			String msg = "Return Date was Updated";
			return Response.status(200).entity(msg).build();
		} else {
			String msg = "Return Date was Not Updated";
			return Response.status(404).entity(msg).build();
		}
	}
	
	// RESTful method for Deleting rental
	@Override
	public Response deleteRental(String value) throws RemoteException, MalformedURLException, NotBoundException {

		// deleting the rental with entered value
		boolean check = new RMI_Client().deleteRental(value);

		// if deleted return status 200 otherwise return status 404
		if (check) {

			String msg = "The Order Number " + value + " was Deleted!";
			return Response.status(200).entity(msg).build();
			
		} else {
			String msg = "The Order Number " + value + " was NOT Deleted!";
			return Response.status(404).entity(msg).build();
		}
	}
}
