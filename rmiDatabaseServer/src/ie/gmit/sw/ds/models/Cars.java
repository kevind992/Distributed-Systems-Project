package ie.gmit.sw.ds.models;

import java.io.Serializable;

public class Cars implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int rentalId;
	private String carReg;
	private String carMake;
	private String carModel;
	private String fuelType;
	private int seats;
	private String transmission;
	private String carSize;
	private Boolean carRented;
	
	
	public Cars() {
		super();
	}


	public int getRentalId() {
		return rentalId;
	}


	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}


	public String getCarReg() {
		return carReg;
	}


	public void setCarReg(String carReg) {
		this.carReg = carReg;
	}


	public String getCarMake() {
		return carMake;
	}


	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}


	public String getCarModel() {
		return carModel;
	}


	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}


	public String getFuelType() {
		return fuelType;
	}


	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}


	public int getSeats() {
		return seats;
	}


	public void setSeats(int seats) {
		this.seats = seats;
	}


	public String getTransmission() {
		return transmission;
	}


	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}


	public String getCarSize() {
		return carSize;
	}


	public void setCarSize(String carSize) {
		this.carSize = carSize;
	}


	public Boolean getCarRented() {
		return carRented;
	}


	public void setCarRented(Boolean carRented) {
		this.carRented = carRented;
	}
	
}
