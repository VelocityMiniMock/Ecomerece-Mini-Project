package Products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductDB {

	public void createProductTable() {
		try (Connection conn = DBConnection.getCon()) {
			Statement stmt = conn.createStatement();
			String sql = "create table Products(productId int not null AUTO_INCREMENT,productName varchar(100), productDesc varchar(150), price int not null, quantity int not null,PRIMARY KEY(productId))";
			stmt.executeUpdate(sql);
			System.out.println("Table created successfully...");
		} catch (Exception e) {
			System.out.print("Unable to Create Table because "+e.getMessage());
		}
	}
	
	public void addDummyList() {
		try {
			for (int i = 1; i < 11; i++) {
				productRegister(new Products(i, "Product " + i, "Product" + 1 + " Description", i * 1000, i * 5));
			}
		} catch (Exception e) {
			System.out.print("Unable to add entry because "+e.getMessage());
		}
	}
	
	
	public void addDummyUser() {
		try {
			for (int i = 1; i < 5; i++) {
				
			}
		} catch (Exception e) {
			System.out.print("Unable to add entry because "+e.getMessage());
		}
	}

	protected void productRegister(Products products) {
		try (Connection conn = DBConnection.getCon()) {
			PreparedStatement statement = conn.prepareStatement(
					"INSERT INTO products (productName, productDesc,price,quantity) VALUES (?,?,?,?);");
			statement.setString(1, products.getName());
			statement.setString(2, products.getDescription());
			statement.setFloat(3, products.getPrice());
			statement.setInt(4, products.getQuantity());
			if (statement.executeUpdate() >= 1)
				System.out.println("New Item added to Stock");
			
		} catch (Exception e) {
			System.out.print("Unable to add item"+e.getMessage());
		}
	}
	
	protected boolean isProductAvailable(int id) {
		try (Connection conn = DBConnection.getCon()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from products where productId="+id);
			if(rs.next()) {
			 return true;
			}
			else 
			{
				return false;
			}
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}
	
	protected Object findProductsById(int id) {
		try (Connection conn = DBConnection.getCon()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from products where productId="+id);
			if(rs.next()) {
			 return new Products(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5));
			}
			else 
			{
				System.out.println("Product not Found");
				System.exit(0);
				return null;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null; 

	}

	@SuppressWarnings("finally")
	protected ArrayList<Products> getProductList() {
		ArrayList<Products> list = new ArrayList<>();
		try (Connection conn = DBConnection.getCon()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from products");
			while (rs.next()) {
				list.add(new Products(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5)));
			}

		} catch (Exception e) {
			System.out.println(e);
			System.exit(0);

		} finally {
			return list;
		}
	}

}
