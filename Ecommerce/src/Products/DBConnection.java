package Products;

import java.sql.*;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Column;


public class DBConnection {

	@SuppressWarnings("finally")
	public static Connection getCon() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ecommerce", "root", "Password");
		} catch (Exception e) {
			System.out.println("Unable to Connect with DataBase "+ e);
			System.exit(0);
		}
		finally {
			return con;
		}
	}

	public DBConnection() {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "Password")) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Statement stmt = con.createStatement();
			String sql = "CREATE DATABASE Ecommerce";
			stmt.executeUpdate(sql);
			//System.out.println("Database created successfully...");
		} catch (Exception e) {
//			System.out.print("Unable to Create Databse because "+e.getMessage());
		}
	}

	
}
