package com.webclient.marshaller;

import java.util.*;

import com.webclient.models.Cars;
import com.webclient.models.Rentals;

public class TestRunner {
	public static void main(String[] args) {
		HTTP_Requests test = new HTTP_Requests();
		
		Rentals r = test.getAllCars();
		
		for (Cars cars : r.getCars()) {
			System.out.println(cars.getCarMake() + " " + cars.getCarModel());
		}
	}
}
