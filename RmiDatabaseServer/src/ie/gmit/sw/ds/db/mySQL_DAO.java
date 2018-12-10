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

	// url to the database car_rental_booking_db
	private String url = "jdbc:mysql://localhost:3306/car_rental_booking_db?useSSL=false";

	// Method for getting all rentals
	public ArrayList<Rentals> getRental() throws RemoteException {

		ArrayList<Rentals> rentalList = new ArrayList<>();

		try (

				// Making the connection
				Connection conn = DriverManager.getConnection(url, "root", "");
				Statement stmt = conn.createStatement();) {
			// Select statement
			String strSelect = "select a.acc_no , a.first_name, a.surname, a.dob, a.address, "
					+ "c.car_make, c.car_model, r.rental_date, r.return_date from rentals r "
					+ "inner join accounts a on r.acc_no = a.acc_no inner join cars c "
					+ "on r.rental_id = c.rental_id;";

			ResultSet rset = stmt.executeQuery(strSelect);

			while (rset.next()) { // Move the cursor to the next row, return false if no more row

				Rentals rental = new Rentals();
				Accounts accounts = new Accounts();
				Cars cars = new Cars();

				// Added the selected values to a rentals object
				accounts.setAccNo(String.valueOf(rset.getInt("acc_no")));
				accounts.setFname(rset.getString("first_name"));
				accounts.setSurname(rset.getString("surname"));
				accounts.setDob(rset.getString("dob"));
				accounts.setAddress(rset.getString("address"));
				cars.setCarMake(rset.getString("car_make"));
				cars.setCarModel(rset.getString("car_model"));
				rental.setRentalDate(rset.getString("rental_date"));
				rental.setReturnDate(rset.getString("return_date"));
				rental.setAccounts(accounts);
				rental.getCars().add(cars);
				
				rentalList.add(rental);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Error");
		}
		System.out.println("Data successfully pull from db..");
		return rentalList;
	}
	
	// Method for getting all account numbers
	public ArrayList<String> getAccounts() throws RemoteException {

		ArrayList<String> accountList = new ArrayList<>();
		
		try (

				Connection conn = DriverManager.getConnection(url, "root", "");
				Statement stmt = conn.createStatement();) {
			String strSelect = "select acc_no from accounts;";

			ResultSet rset = stmt.executeQuery(strSelect);

			while (rset.next()) { // Move the cursor to the next row, return false if no more row

				String acc;
				
				acc = String.valueOf(rset.getInt("acc_no"));
				
				accountList.add(acc);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Error");
		}
		System.out.println("Data successfully pull from db..");
		return accountList;

	}
	// method for getting rental ids
	public ArrayList<Integer> getRentalId() throws RemoteException {

		ArrayList<Integer> idList = new ArrayList<>();
		
		try (

				Connection conn = DriverManager.getConnection(url, "root", "");
				Statement stmt = conn.createStatement();) {
			String strSelect = "select id from rentals;";

			ResultSet rset = stmt.executeQuery(strSelect);

			while (rset.next()) { // Move the cursor to the next row, return false if no more row

				int acc;
				
				acc = rset.getInt("id");
				
				idList.add(acc);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Error");
		}
		System.out.println("Data successfully pull from db..");
		return idList;
	}
	
	// Method for getting all cars
	public Rentals getCars() throws RemoteException {

		Rentals rentals = new Rentals();
		// ArrayList<Cars> carsList = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(url, "root", ""); Statement stmt = conn.createStatement();) {

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
				cars.setTransmission(rset.getString("transmission"));
				cars.setCarSize(rset.getString("car_size"));
				// cars.setCarRented(rset.getBoolean("car_rented"));

				rentals.getCars().add(cars);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Data successfully pulled from db..");
		return rentals;
	}
	
	// method for executing a db update
	public boolean updateDB(String statement) {

		try (

				Connection conn = DriverManager.getConnection(url, "root", "");
				Statement stmt = conn.createStatement();) {

			stmt.executeUpdate(statement);

			System.out.println("records updated.\n");
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
