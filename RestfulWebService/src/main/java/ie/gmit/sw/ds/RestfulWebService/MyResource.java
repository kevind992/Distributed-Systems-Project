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
@Path("/createbooking")
public class MyResource implements MyResourceInterface {

	private ArrayList<Rentals> rts = new ArrayList<>();
	private ArrayList<String> accNum = new ArrayList<>();

	public Rentals getOrder(String value) throws Exception {

		rts = new RMI_Client().getData();

		Rentals requested = null;

		for (Rentals r : rts) {
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

	public Rentals getAllCars() throws Exception {
		return new RMI_Client().getAllCars();
	}

	public Response createRental(Rentals toCreate) throws RemoteException, MalformedURLException, NotBoundException {

		accNum = new RMI_Client().getAccNum();

		Boolean check = false;
		int count = 0;

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