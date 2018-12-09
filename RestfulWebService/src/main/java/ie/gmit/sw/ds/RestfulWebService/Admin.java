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
	
	@Override
	public Response getAllRentals() throws Exception {
		
		rts = new RMI_Client().getData();
		
		GenericEntity<ArrayList<Rentals>> genericEntity = new GenericEntity<ArrayList<Rentals>>(rts) {
	      };//needs empty body to preserve generic type
		
		System.out.println("All rentals pulled");
		
		return Response.ok(genericEntity)
                .header("someHeader", "someHeaderValue")
                .build();
	}

	
	
	
}
