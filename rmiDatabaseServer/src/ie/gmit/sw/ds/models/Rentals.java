package ie.gmit.sw.ds.models;

import java.io.Serializable;

public class Rentals implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String rentalDate;
	private String returnDate;
	
	private Accounts accounts;
	private Cars cars;
	
	public Rentals() {
		super();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(String rentalDate) {
		this.rentalDate = rentalDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public Accounts getAccounts() {
		return accounts;
	}

	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}

	public Cars getCars() {
		return cars;
	}

	public void setCars(Cars cars) {
		this.cars = cars;
	}
}
