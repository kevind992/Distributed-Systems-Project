package ie.gmit.sw.ds.http;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import ie.gmit.sw.ds.models.Rentals;

public class HTTP_Requests {

	private Rentals rentals;

	private String resourceCreateURL = "http://localhost:8080/RestfulWebService/webapi/create/";
	private String resourceManageUrl = "http://localhost:8080/RestfulWebService/webapi/manage/";
	private URL url;
	private HttpURLConnection con;
	private String resultInXml = "";

	public HTTP_Requests() {
		super();
	}

	// Get all Rentals
	public Rentals getRentals(String request) {
		return makeGetRequest(resourceCreateURL, request);
	}

	// Create Account
	public boolean createAccount(Rentals rentals) {
		return makePostRequest(rentals, resourceCreateURL, rentals.getAccounts().getAccNo());
	}

	// Get all cars
	public Rentals getAllCars() {
		return makeGetRequest(resourceCreateURL, "getcars");
	}

	// Create Rental
	public boolean createRental(Rentals rental) {
		return makePostRequest(rental, resourceCreateURL, "createrental");
	}

	// Update Car
	public boolean updateCar(Rentals rental) {
		return makePutRequest(rental, resourceManageUrl, "updatecar");
	}

	// Update Rental Date
	public boolean updateRentalDate(Rentals rental) {
		return makePutRequest(rental, resourceManageUrl, "updaterentaldate");
	}

	// Update Return Date
	public boolean updateReturnDate(Rentals rental) {
		return makePutRequest(rental, resourceManageUrl, "updatereturndate");
	}

	// Delete Rental
	public boolean deleteRental(Rentals rental) {
		return makeDeleteRequest(resourceManageUrl, rental.getAccounts().getAccNo());
	}

	// HTTP method for deleting a Rental
	private boolean makeDeleteRequest(String urlResourse, String request) {

		try {
			// Making connection
			url = new URL(urlResourse + request);
			con = (HttpURLConnection) url.openConnection();
			con.setDoInput(true);
			con.setInstanceFollowRedirects(false);
			// Setting method a delete
			con.setRequestMethod("DELETE");
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			con.setRequestProperty("charset", "utf-8");
			con.setUseCaches(false);

			// If the response is 201 return true if not return false
			if (con.getResponseCode() == 201) {
				con.disconnect();
				return true;
			} else {
				con.disconnect();
				return false;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error Sending..");
			e.printStackTrace();
			return false;
		}
	}

	// HTTP method for sending a PUT request
	private boolean makePutRequest(Rentals rental, String urlResourse, String request) {

		// Marshaling before sending
		String str = getOrderAsXML(rental);

		try {

			// Making connection
			url = new URL(urlResourse + request);
			con = (HttpURLConnection) url.openConnection();
			// Setting the request to PUT
			con.setRequestMethod("PUT");
			con.setRequestProperty("Content-Type", "application/xml");

			con.setDoOutput(true);
			OutputStream output = new BufferedOutputStream(con.getOutputStream());
			output.write(str.getBytes());
			output.flush();

			con.disconnect();

			// Getting the response
			int responseCode = con.getResponseCode();

			// if the response is 200 return true otherwise return false
			if (responseCode == 200) {
				return true;
			} else {
				return false;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error Sending..");
			e.printStackTrace();
			return false;
		}
	}

	// HTTP method for making a GET request
	private Rentals makeGetRequest(String urlResourse, String request) {

		Rentals rental = new Rentals();

		// try to create a connection and request XML format
		try {
			// Making connection
			url = new URL(urlResourse + request);
			con = (HttpURLConnection) url.openConnection();
			// Setting the request to GET
			con.setRequestMethod("GET");
			con.setRequestProperty("Accept", "application/xml");
			InputStream in = con.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			resultInXml = br.lines().collect(Collectors.joining());
			con.disconnect();

			// Changing the returned response from xml into a rental object
			rental = new HTTP_Requests().getPoFromXml(resultInXml);

			return rental;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// HTTP method for making a POST request
	private boolean makePostRequest(Rentals rental, String urlResourse, String request) {

		// changing the to xml
		String str = getOrderAsXML(rental);

		try {
			// Making the connection
			url = new URL(urlResourse + request);
			con = (HttpURLConnection) url.openConnection();
			// Setting the requested type to POST
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/xml");

			con.setDoOutput(true);
			OutputStream output = new BufferedOutputStream(con.getOutputStream());
			output.write(str.getBytes());
			output.flush();

			// Getting the response
			int responseCode = con.getResponseCode();
			con.disconnect();

			// if the response is 201 then return true otherwise return false
			if (responseCode == 201) {
				return true;
			} else {
				return false;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error Sending..");
			e.printStackTrace();
			return false;
		}
	}

	// Method for converting xml to a POJO
	private Rentals getPoFromXml(String input) {
		// Unmarshal the PurchaseOrder from XML
		StringReader sr1 = new StringReader(input);
		Unmarshaller um1;
		try {
			JAXBContext jc = JAXBContext.newInstance("com.webclient.models");
			um1 = jc.createUnmarshaller();
			StreamSource source1 = new StreamSource(sr1);
			JAXBElement<Rentals> poElement1 = um1.unmarshal(source1, Rentals.class);
			this.rentals = (Rentals) poElement1.getValue();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.rentals;
	}

	// Method for converting a POJO to xml
	private String getOrderAsXML(Rentals po) {
		// Marshal the PurchaseOrder into XML
		StringWriter sw = new StringWriter();
		Marshaller m;
		try {
			JAXBContext jc = JAXBContext.newInstance("com.webclient.models");
			m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(po, sw);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sw.toString();
	}
}
