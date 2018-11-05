package ie.gmit.sw.ds.models;

import java.io.Serializable;





public class Accounts implements Serializable{

    
	private static final long serialVersionUID = 1L;
	
    protected String accNo;
    protected String fName;
    protected String surname;
    protected String dob;
    protected String address;

    
    public String getAccNo() {
        return accNo;
    }

    
    public void setAccNo(String value) {
        this.accNo = value;
    }

    
    public String getFName() {
        return fName;
    }

   
    public void setFName(String value) {
        this.fName = value;
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
