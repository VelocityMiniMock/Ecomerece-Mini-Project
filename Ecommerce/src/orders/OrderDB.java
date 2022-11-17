package orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Products.DBConnection;
import Products.Products;

public class OrderDB {
	public OrderDB() {
		createOrderDBTable();
	}

	public void createOrderDBTable() {
		try (Connection conn = DBConnection.getCon()) {
			Statement stmt = conn.createStatement();
			String sql = "create table Orders(orderId int not null ,userID int not null , ProductID int not null, quantity int not null)";
			stmt.executeUpdate(sql);
			//System.out.println("Table created successfully...");
		} catch (Exception e) {
			//System.out.print("Unable to Create Table because "+e.getMessage());
		}
	}
public void makeOrders(int orderID,int userID,int productID,int quantity) {
	try (Connection conn = DBConnection.getCon()) {
		PreparedStatement statement = conn.prepareStatement(
				"INSERT INTO orders (orderId, userID,ProductID,quantity) VALUES (?,?,?,?);");
		statement.setInt(1,orderID);
		statement.setInt(2, userID);
		statement.setInt(3, productID );
		statement.setInt(4, quantity);
	
		if (statement.executeUpdate() >= 1)
			System.out.println("New Orders is added:");
		
	} catch (Exception e) {
		System.out.print("Unable to add item"+e.getMessage());
	}
}
public ArrayList<Products> findordersByuserId(int id) {
	ArrayList<Products> list = new ArrayList<>();
	try (Connection conn = DBConnection.getCon()) {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from products where productId in(select productID from orders Where userID ="+id+");");
		
		while (rs.next()) {
			list.add(new Products(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5)));
		}
	
	
	} catch (Exception e) {
		System.out.println(e);
	}
	return list;

}
}
