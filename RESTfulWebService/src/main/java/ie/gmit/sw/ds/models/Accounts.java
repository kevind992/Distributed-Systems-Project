package ie.gmit.sw.ds.models;

import java.io.Serializable;
import java.rmi.RemoteException;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Accounts", namespace = "http://sw.gmit.ie/models/", propOrder = { "acc_no", "f_name", "surname", "dob",
		"address" })

public class Accounts implements Serializable {

	public Accounts() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	@XmlElement(namespace = "http://sw.gmit.ie/models/", required = true)
	private String acc_no;
	@XmlElement(namespace = "http://sw.gmit.ie/models/", required = true)
	private String f_name;
	@XmlElement(namespace = "http://sw.gmit.ie/models/", required = true)
	private String surname;
	@XmlElement(namespace = "http://sw.gmit.ie/models/", required = true)
	private String dob;
	@XmlElement(namespace = "http://sw.gmit.ie/models/", required = true)
	private String address;

	public String getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(String acc_no) {
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
