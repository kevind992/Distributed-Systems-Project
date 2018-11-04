package ie.gmit.sw.ds.models;

import java.io.Serializable;
import java.rmi.RemoteException;

public class Accounts implements Serializable{

	public Accounts() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	
	private int acc_no;
	private String f_name;
	private String surname;
	private String dob;
	private String address;
	
	

	public int getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
