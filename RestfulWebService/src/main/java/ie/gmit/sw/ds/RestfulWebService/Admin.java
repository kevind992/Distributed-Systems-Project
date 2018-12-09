package ie.gmit.sw.ds.RestfulWebService;

import java.util.ArrayList;

import javax.inject.Singleton;
import javax.ws.rs.Path;
import ie.gmit.sw.ds.models.Rentals;
import ie.gmit.sw.ds.rmi.RMI_Client;

@Singleton
@Path("/admin")
public class Admin implements AdminInterface{

	private ArrayList<Rentals> rts = new ArrayList<>();
	
	@Override
	public Rentals getAllRentals() throws Exception {
		
		rts = new RMI_Client().getData();
		
		System.out.println("All rentals pulled");
		
		return null;
	}

	
	
	
}
