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

public class mySQL_DAO {

	public ArrayList<Rentals> getRental() throws RemoteException {

		ArrayList<Rentals> rentalList = new ArrayList<>();

		try (

				Connection conn = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/car_rental_booking_db?useSSL=false", "root", "");

				Statement stmt = conn.createStatement();) {

			String strSelect = "select a.first_name, a.surname, a.dob, a.address, "
					+ "c.car_make, c.car_model, r.rental_date, r.return_date from rentals r "
					+ "inner join accounts a on r.acc_no = a.acc_no inner join cars c "
					+ "on r.rental_id = c.rental_id;";

			ResultSet rset = stmt.executeQuery(strSelect);

			
			while (rset.next()) { // Move the cursor to the next row, return false if no more row

				Rentals rental = new Rentals();
				Accounts accounts = new Accounts();
				Cars cars = new Cars();

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

}
