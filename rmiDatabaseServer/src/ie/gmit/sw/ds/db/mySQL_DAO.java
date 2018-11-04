package ie.gmit.sw.ds.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ie.gmit.sw.ds.models.Accounts;

public class mySQL_DAO {

	public ArrayList<Accounts> getAccounts() {

		ArrayList<Accounts> accList = new ArrayList<>();

		try (

				Connection conn = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/car_rental_booking_db?useSSL=false", "root", "");

				Statement stmt = conn.createStatement();) {

			String strSelect = "select acc_no, first_name, surname, dob, address  from accounts";

			ResultSet rset = stmt.executeQuery(strSelect);

			int rowCount = 0;
			while (rset.next()) { // Move the cursor to the next row, return false if no more row

				Accounts acc = new Accounts();

				acc.setAcc_no(rset.getInt("acc_no"));
				acc.setF_name(rset.getString("first_name"));
				acc.setSurname(rset.getString("surname"));
				acc.setDob(rset.getString("dob"));
				acc.setAddress(rset.getString("address"));

				++rowCount;

				accList.add(acc);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return accList;
	}

}
