package ie.gmit.sw.ds.RestfulWebService;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.inject.Singleton;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import ie.gmit.sw.ds.models.Cars;
import ie.gmit.sw.ds.models.Rentals;
import ie.gmit.sw.ds.rmi.RMI_Client;

@Singleton
@Path("/createbooking")
public class MyResource implements MyResourceInterface {

	private ArrayList<Rentals> rts = new ArrayList<>();

	public Rentals getOrder(String value) throws Exception {

		rts = new RMI_Client().getData();

		Rentals requested = null;

		for (Rentals r : rts) {
			System.out.println(r);
			if (r.getAccounts().getAccNo().equals(value)) {
				requested = r;
			}
		}

		return requested;
	}

	public Response createAccount(String value, Rentals toCreate)
			throws RemoteException, MalformedURLException, NotBoundException {
		
		System.out.println("Added..");
		
		rts = new RMI_Client().getData();

		Boolean check = false;

		for (Rentals r : rts) {
			System.out.println(r.getAccounts().getAccNo() + " == " + value);
			if (r.getAccounts().getAccNo().equals(value)) {
				System.out.println("Check is true..");
				check = true;
			}
		}

		if (check == true) {
			String msg = "The account number " + value + " already exists";
			return Response.status(409).entity(msg).build();
		} else {
			
			Boolean created = true;

			new RMI_Client().createAccount(toCreate);
			System.out.println("created..");

			if (created) {
				String msg = "Resource created!";
				return Response.status(201).entity(msg).build(); // return 201 for resource created
			} else {
				String msg = "Account not created!";
				return Response.status(409).entity(msg).build();
			}
		}
	}

	@Override
	public Rentals getAllCars() throws Exception {
		return new RMI_Client().getAllCars();
	}
}