package com.webclient.http;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.webclient.models.Cars;
import com.webclient.models.Rentals;

public class HTTP_Requests {

	private Rentals rentals;

	private String resourceBaseURL = "http://localhost:8080/RestfulWebService/webapi/createbooking/";
	private URL url;
	private HttpURLConnection con;
	private String resultInXml = "";

	public HTTP_Requests() {
		super();
	}

	public Rentals getRentals(String request) {
		return makeGetRequest(request);
	}

	public boolean createAccount(Rentals rentals) {
		return makePostRequest(rentals, rentals.getAccounts().getAccNo());
	}

	public Rentals getAllCars() {
		return makeGetRequest("getcars");
	}

	public boolean createRental(Rentals rental) {
		return makePostRequest(rental, "createrental");
	}

	public void updateCar(Rentals rental) {
		makePutRequest(rental, "updatecar");
	}

	public void updateRentalDate(Rentals rental) {
		makePutRequest(rental, "updaterentaldate");
	}
	
	public void updateReturnDate(Rentals rental) {
		makePutRequest(rental, "updatereturndate");
	}
	
	public void deleteRental(Rentals rental) {
		makeDeleteRequest(rental.getAccounts().getAccNo());
	}

	private void makeDeleteRequest(String request) {
		
		try {

			url = new URL(resourceBaseURL + request);
			con = (HttpURLConnection) url.openConnection();
			con.setDoInput(true);
			con.setInstanceFollowRedirects(false); 
			con.setRequestMethod("DELETE"); 
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
			con.setRequestProperty("charset", "utf-8");
			con.setUseCaches (false);

			System.out.println("Response code: " + con.getResponseCode());
			
			con.disconnect();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error Sending..");
			e.printStackTrace();
		}
	}

	private void makePutRequest(Rentals rental, String request) {

		String str = getOrderAsXML(rental);

		try {

			url = new URL(resourceBaseURL + request);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("PUT");
			con.setRequestProperty("Content-Type", "application/xml");

			con.setDoOutput(true);
			OutputStream output = new BufferedOutputStream(con.getOutputStream());
			output.write(str.getBytes());
			output.flush();

			con.disconnect();

			int responseCode = con.getResponseCode();
			System.out.println("POST Response Code : " + responseCode);

			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				// print result
				System.out.println(response.toString());
			} else {
				System.out.println("request not worked");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error Sending..");
			e.printStackTrace();
		}
	}

	private Rentals makeGetRequest(String request) {

		Rentals rental = new Rentals();

		// try to create a connection and request XML format
		try {
			url = new URL(resourceBaseURL + request);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Accept", "application/xml");
			InputStream in = con.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			resultInXml = br.lines().collect(Collectors.joining());
			con.disconnect();

			rental = new HTTP_Requests().getPoFromXml(resultInXml);

			return rental;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private boolean makePostRequest(Rentals rental, String request) {

		String str = getOrderAsXML(rental);

		try {

			url = new URL(resourceBaseURL + request);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/xml");

			con.setDoOutput(true);
			OutputStream output = new BufferedOutputStream(con.getOutputStream());
			output.write(str.getBytes());
			output.flush();

			con.disconnect();

			int responseCode = con.getResponseCode();
			System.out.println("POST Response Code : " + responseCode);

			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				// print result
				System.out.println(response.toString());
			} else {
				System.out.println("request not worked");
			}
			if(responseCode == 201) {
				return true;
			}else {
				return false;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error Sending..");
			e.printStackTrace();
			return false;
		}
	}

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