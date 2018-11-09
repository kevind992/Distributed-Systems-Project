package com.webclient.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.webclient.models.Rentals;

@Controller
public class CreateBookingController {

	private String resourceBaseURL = "http://localhost:8080/RestfulWebService/webapi/createbooking/";
	private String requestedOrder = "1001";
	private URL url;
	private HttpURLConnection con;
	private String resultInXml = "";

	@GetMapping("/createbooking")
	public String createBooking() {

		getRentals();
		
		return "createbooking";
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
			
			rentals = getPoFromXml(resultInXml);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(rentals.getAccounts().getFname() + " " + rentals.getAccounts().getSurname());
		
	}
	
	private Rentals getPoFromXml(String input) {
		// Unmarshal the PurchaseOrder from XML
		StringReader sr1 = new StringReader(input);
		Unmarshaller um1;
		Rentals poFromXml = null;
		try {
			JAXBContext jc = JAXBContext.newInstance("com.webclient.models");
			um1 = jc.createUnmarshaller();
			StreamSource source1 = new StreamSource(sr1);
			JAXBElement<Rentals> poElement1 = um1.unmarshal(source1, Rentals.class);
			poFromXml = (Rentals) poElement1.getValue();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return poFromXml;
		
	}

}
