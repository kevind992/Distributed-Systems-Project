package ie.gmit.sw.ds.RestfulWebService;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ie.gmit.sw.ds.models.Rentals;

public interface MyResourceInterface {
	
	@GET
	@Produces({MediaType.APPLICATION_XML})
	@Path("/{value}")
	public Rentals getOrder(@PathParam("value") String value) throws Exception;
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/{value}")
	public Response createAccount(@PathParam("value") String value, Rentals toCreate) throws RemoteException 
	, MalformedURLException, NotBoundException;

	@GET
	@Produces({MediaType.APPLICATION_XML})
	@Path("/getcars")
	public Rentals getAllCars() throws Exception;
}
