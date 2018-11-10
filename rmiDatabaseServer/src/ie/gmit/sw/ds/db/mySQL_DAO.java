package ie.gmit.sw.ds.db;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ie.gmit.sw.ds.models.Accounts;
import ie.gmit.sw.ds.models.Cars;
import ie.gmit.sw.ds.models.Rentals;

public class mySQL_DAO implements mySQLDAOInterface {
	
	private String url = "jdbc:mysql://localhost:3306/car_rental_booking_db?useSSL=false";

	public ArrayList<Rentals> getRental() throws RemoteException {

		ArrayList<Rentals> rentalList = new ArrayList<>();

		try (

				Connection conn = DriverManager.getConnection(url, "root", "");
				Statement stmt = conn.createStatement();)
		{
			String strSelect = "select a.acc_no , a.first_name, a.surname, a.dob, a.address, "
					+ "c.car_make, c.car_model, r.rental_date, r.return_date from rentals r "
					+ "inner join accounts a on r.acc_no = a.acc_no inner join cars c "
					+ "on r.rental_id = c.rental_id;";

			ResultSet rset = stmt.executeQuery(strSelect);

			while (rset.next()) { // Move the cursor to the next row, return false if no more row

				Rentals rental = new Rentals();
				Accounts accounts = new Accounts();
				Cars cars = new Cars();

				accounts.setAccNo(String.valueOf(rset.getInt("acc_no")));
				accounts.setFname(rset.getString("first_name"));
				accounts.setSurname(rset.getString("surname"));
				accounts.setDob(rset.getString("dob"));
				accounts.setAddress(rset.getString("address"));
				cars.setCarMake(rset.getString("car_make"));
				cars.setCarMake(rset.getString("car_model"));
				rental.setRentalDate(rset.getString("rental_date"));
				rental.setReturnDate(rset.getString("return_date"));
				rental.setAccounts(accounts);
				rental.setCars(cars);

				rentalList.add(rental);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Data successfully pull from db..");
		return rentalList;
	}
	
	public Boolean createAccount(Rentals a) {
		
		try (

				Connection conn = DriverManager.getConnection(url, "root", "");

				Statement stmt = conn.createStatement();)
		{
			
			// INSERT a record
	         String sqlInsert = "insert into accounts " // need a space
	               + "values ('"+a.getAccounts().getAccNo() + "','" + a.getAccounts().getFname() + "','" 
	        		 + a.getAccounts().getSurname() + "','" + a.getAccounts().getDob() 
	               + "','" + a.getAccounts().getAddress() + "');";
	         
	         System.out.println("The SQL query is: " + sqlInsert);  // Echo for debugging
	         int countInserted = stmt.executeUpdate(sqlInsert);
	         
	         System.out.println(countInserted + " records inserted.\n");
	         
	         return true;
	         
		}catch (Exception e) {
			return false;
		}
	}
	
	public ArrayList<Cars> getCars() throws RemoteException{
		
		ArrayList<Cars> carsList = new ArrayList<>();
		
		try (
				Connection conn = DriverManager.getConnection(url, "root", "");
				Statement stmt = conn.createStatement();)
		{

			String strSelect = "select * from cars ";
			ResultSet rset = stmt.executeQuery(strSelect);

			while (rset.next()) { // Move the cursor to the next row, return false if no more row				
				Cars cars = new Cars();

				cars.setRentalId(rset.getInt("rental_id"));
				cars.setCarReg(rset.getString("car_reg"));
				cars.setCarMake(rset.getString("car_make"));
				cars.setCarModel(rset.getString("car_model"));
				cars.setFuelType(rset.getString("fuel_type"));
				cars.setSeats(rset.getInt("seats"));
				cars.setTransmission(rset.getString("tranmission"));
				cars.setCarSize(rset.getString("car_size"));
				cars.setCarRented(rset.getBoolean("car_rented"));

				carsList.add(cars);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Data successfully pulled from db..");
		return carsList;
	}
}
