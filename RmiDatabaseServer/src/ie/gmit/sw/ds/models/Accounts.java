//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1-b171012.0423 
//         See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2018.12.04 at 11:13:19 AM GMT 
//


package ie.gmit.sw.ds.models;

import java.io.Serializable;

public class Accounts implements Serializable{

	private static final long serialVersionUID = 1L;
	protected String accNo;
    protected String fname;
    protected String surname;
    protected String dob;
    protected String address;

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String value) {
        this.accNo = value;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String value) {
        this.fname = value;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String value) {
        this.surname = value;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String value) {
        this.dob = value;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String value) {
        this.address = value;
    }
}
