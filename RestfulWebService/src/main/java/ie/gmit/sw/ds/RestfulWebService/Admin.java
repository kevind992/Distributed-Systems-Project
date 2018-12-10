// Author: Kevin Delassus - G00270791
package ie.gmit.sw.ds.RestfulWebService;

import java.util.ArrayList;

import javax.inject.Singleton;
import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import ie.gmit.sw.ds.models.Rentals;
import ie.gmit.sw.ds.rmi.RMI_Client;

@Singleton
@Path("/admin")
public class Admin implements AdminInterface{

	private ArrayList<Rentals> rts = new ArrayList<>();
	
	// RESTful method for getting all the Rentals and returning them as a generic entity 
	@Override
	public Response getAllRentals() throws Exception {
		
		// Making the RMI call and returning a list of Rentals 
		rts = new RMI_Client().getData();
		
		// Wrapping the List as a GenericEntity
		GenericEntity<ArrayList<Rentals>> genericEntity = new GenericEntity<ArrayList<Rentals>>(rts) {
	      };//needs empty body to preserve generic type
		
		System.out.println("All rentals pulled");
		
		// Returning the GenericEntity in the response
		return Response.ok(genericEntity)
                .header("someHeader", "someHeaderValue")
                .build();
	}
}
