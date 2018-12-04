package com.webclient.marshaller;

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
	private String requestedOrder;
	private URL url;
	private HttpURLConnection con;
	private String resultInXml = "";

	public HTTP_Requests() {
		super();
	}

	public void getRentals() {

		Rentals rentals = new Rentals();

		// try to create a connection and request XML format
		try {
			url = new URL(resourceBaseURL + requestedOrder);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Accept", "application/xml");
			InputStream in = con.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			resultInXml = br.lines().collect(Collectors.joining());
			con.disconnect();

			rentals = new HTTP_Requests().getPoFromXml(resultInXml);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(rentals.getAccounts().getFname() + " " + rentals.getAccounts().getSurname());

	}

	public void createAccount(Rentals rentals) {
		makePostRequest(rentals, rentals.getAccounts().getAccNo());
	}

	public Rentals getAllCars() {
		return makeGetRequest("getcars");
	}

	public void createRental(Rentals rental) {
		makePostRequest(rental, "createrental");
	}
	
	public Rentals makeGetRequest(String request) {
		
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
	
	public void makePostRequest(Rentals rental, String request) {
		
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

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error Sending..");
			e.printStackTrace();
		}
	}
	
	public Rentals getPoFromXml(String input) {
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
