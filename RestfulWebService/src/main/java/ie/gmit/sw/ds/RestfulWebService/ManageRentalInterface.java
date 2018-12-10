package ie.gmit.sw.ds.RestfulWebService;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ie.gmit.sw.ds.models.Rentals;

//An interface which contains all the jax-rs anotations for ManageRental
public interface ManageRentalInterface {

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/updatecar")
	public Response updateCar(Rentals toChange) throws RemoteException 
	, MalformedURLException, NotBoundException;

	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/updaterentaldate")
	public Response updateRentalDate(Rentals toChange) throws RemoteException 
	, MalformedURLException, NotBoundException;
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/updatereturndate")
	public Response updateReturnDate(Rentals toChange) throws RemoteException 
	, MalformedURLException, NotBoundException;
	
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{value}")
	public Response deleteRental(@PathParam("value") String value) throws RemoteException 
	, MalformedURLException, NotBoundException;
	
}
