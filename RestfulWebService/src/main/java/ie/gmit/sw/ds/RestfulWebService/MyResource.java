package ie.gmit.sw.ds.RestfulWebService;

import java.util.ArrayList;

import javax.inject.Singleton;
import javax.ws.rs.Path;

import ie.gmit.sw.ds.models.Rentals;
import ie.gmit.sw.ds.rmi.rmiClient;

@Singleton
@Path("/createbooking")
public class MyResource implements MyResourceInterface{

	private ArrayList<Rentals> acc = new ArrayList<>();
	
	public Rentals getOrder(String value) throws Exception {
		
        acc = new rmiClient().getData();
		
		Rentals requested = null;
				
		for (Rentals a : acc) {
			System.out.println(a);
			if (a.getAccounts().getAccNo().equals(value)) {
				requested = a;
			}
		}
		
		return requested;
    }
}