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
public class ManageRental implements ManageRentalInterface{

	public void updateCar(Rentals toChange) throws RemoteException, MalformedURLException, NotBoundException {
		System.out.println("Putting......");
		new RMI_Client().updateCar(toChange);
	}

	@Override
	public void updateRentalDate(Rentals toChange) throws RemoteException, MalformedURLException, NotBoundException {
		new RMI_Client().updateRentalDate(toChange);
	}

	@Override
	public void updateReturnDate(Rentals toChange) throws RemoteException, MalformedURLException, NotBoundException {
		new RMI_Client().updateReturnDate(toChange);
	}

	@Override
	public Response deleteRental(String value) throws RemoteException, MalformedURLException, NotBoundException {

		new RMI_Client().deleteRental(value);

		String msg = "The order number " + value + " was deleted!";
		return Response.status(200).entity(msg).build();
	}
}
