package cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Products.DBConnection;
import Products.Products;

public class CartDB {

	public void createCartDBTable() {
		try (Connection conn = DBConnection.getCon()) {
			Statement stmt = conn.createStatement();
			String sql = "create table Cart(userid int not null,productid int not null,quantity int not null DEFAULT 1)";
			stmt.executeUpdate(sql);
			System.out.println("Table created successfully...");
		} catch (Exception e) {
			System.out.print("Unable to Create Table because "+e.getMessage());
		}
	
	}
public void addToCart(int userid,int productid,int quantity) {
	try (Connection conn = DBConnection.getCon()) {
		PreparedStatement statement = conn.prepareStatement(
				"insert into cart values(?,?,?);");
		statement.setLong(1,userid);
		statement.setLong(2, productid);
		statement.setInt(3, quantity);
		int result = statement.executeUpdate();
		if (statement.executeUpdate() >= 1)
			System.out.println("New Item added to Cart");
		
	} catch (Exception e) {
		System.out.print("Unable to add item"+e.getMessage());
	}
}
public ArrayList<Products> findcartByuserId(int id) {
	ArrayList<Products> list = new ArrayList<>();
	try (Connection conn = DBConnection.getCon()) {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from products where productId in(select productID from cart Where userID ="+id+");");
		
		while (rs.next()) {
			list.add(new Products(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5)));
		}
	
	
	} catch (Exception e) {
		System.out.println(e);
	}
	return list;

}
}
	

