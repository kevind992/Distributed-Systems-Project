package ie.gmit.sw.ds.RestfulWebService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ie.gmit.sw.ds.models.Rentals;

public interface MyResourceInterface {
	
	@GET
	@Produces({MediaType.APPLICATION_XML})
	@Path("/{value}")
	public Rentals getOrder(@PathParam("value") String value) throws Exception;
	
}
