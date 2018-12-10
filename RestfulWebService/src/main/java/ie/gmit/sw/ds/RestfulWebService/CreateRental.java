package ie.gmit.sw.ds.RestfulWebService;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.inject.Singleton;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import ie.gmit.sw.ds.models.Rentals;
import ie.gmit.sw.ds.rmi.RMI_Client;

@Singleton
@Path("/create")
public class CreateRental implements CreateRentalInterface {

	private ArrayList<Rentals> rts = new ArrayList<>();
	private ArrayList<String> accNum = new ArrayList<>();

	// RESTful method for getting all rentals
	public Rentals getRental(String value) throws Exception {

		// Getting all rentals
		rts = new RMI_Client().getData();

		Rentals requested = null;

		// checking if rental exists
		for (Rentals r : rts) {
			if (r.getAccounts().getAccNo().equals(value)) {
				requested = r;
			}
		}
		// returning rental
		return requested;
	}
	// RESTful method for creating an Account
	public Response createAccount(String value, Rentals toCreate)
			throws RemoteException, MalformedURLException, NotBoundException {

		System.out.println("Added..");

		// Getting all rentals
		rts = new RMI_Client().getData();

		Boolean check = false;
		// checking if rental exists
		for (Rentals r : rts) {
			if (r.getAccounts().getAccNo().equals(value)) {
				System.out.println("Check is true..");
				check = true;
			}
		}
		// if rental already exists return a 409 
		if (check == true) {
			String msg = "The account number " + value + " already exists";
			return Response.status(409).entity(msg).build();
		} else { // else try and create a rental

			Boolean created = true;

			new RMI_Client().createAccount(toCreate);
			System.out.println("created..");

			if (created) {
				// if created return a 201
				String msg = "Resource created!";
				return Response.status(201).entity(msg).build(); // return 201 for resource created
			} else {
				// if not created retun a 409
				String msg = "Account not created!";
				return Response.status(409).entity(msg).build();
			}
		}
	}
	// RESTfull method for getting all cars
	public Rentals getAllCars() throws Exception {
		return new RMI_Client().getAllCars();
	}
	
	// RESTfull method fo creating rental
	public Response createRental(Rentals toCreate) throws RemoteException, MalformedURLException, NotBoundException {

		// Getting all account numbers 
		accNum = new RMI_Client().getAccNum();

		Boolean check = false;
		int count = 0;
		
		// Checking accounts numbers against account number user entered 
		for (String acc : accNum) {
			count++;
			if (acc.equals(toCreate.getAccounts().getAccNo())) {
				System.out.println(acc + " = " + toCreate.getAccounts().getAccNo());
				System.out.println("Check is true..");
				check = true;
			}
		}

		System.out.println("Count is: " + count);

		if (check) {
			boolean c = new RMI_Client().createRental(toCreate);
			if (c) {
				String msg = "Account Created";
				System.out.println(msg);
				return Response.status(201).entity(msg).build(); // return 201 for resource created
			} else {
				String msg = "No account under that Account Number";
				return Response.status(409).entity(msg).build(); // return 409 for resource created
			}

		} else {
			String msg = "No account under that Account Number";
			return Response.status(409).entity(msg).build(); // return 409 for resource created
		}
	}

}