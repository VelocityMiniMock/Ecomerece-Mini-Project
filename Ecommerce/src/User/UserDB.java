package User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.callback.UsernameCallback;

import Main.User;
import Products.DBConnection;
import Products.Products;

public class UserDB {
	public void createUserTable() {
		try (Connection conn = DBConnection.getCon()) {
			Statement stmt = conn.createStatement();
			String sql = "create table Users(userId int not null AUTO_INCREMENT,userName varchar(100), userEmailID varchar(100), userMobileNumber varchar(100),userAddress varchar(255),userPassword varchar(255),PRIMARY KEY(userId))";
			stmt.executeUpdate(sql);
			System.out.println("Table created successfully...");
		} catch (Exception e) {
			System.out.print("Unable to Create Table because "+e.getMessage());
		}
	}
	
	public void addUser(Users urd) {
		
	try (Connection conn = DBConnection.getCon()) {
		PreparedStatement statement = conn.prepareStatement(
				"INSERT INTO users (userName, userEmailID, userMobileNumber, userAddress,userPassword) VALUES (?,?,?,?,?);");
		;
		statement.setString(1,urd.getUserName());
		statement.setString(2,urd.getEmailID() );
		statement.setString(3,urd.getMobileNumber());
		statement.setString(4,urd.getAddress());
		statement.setString(5, urd.getPassword());
		int result = statement.executeUpdate();
		if (statement.executeUpdate() >= 1)
			System.out.println("New User added to List");
		
	} catch (Exception e) {
		System.out.print("Unable to add User"+e.getMessage());
	}
}
	@SuppressWarnings("finally")
	public ArrayList<Users> getUserList() {
		ArrayList<Users> list = new ArrayList<>();
		try (Connection conn = DBConnection.getCon()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from users");
			while (rs.next()) {
				list.add(new Users(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6)));
			}

		} catch (Exception e) {
			System.out.println(e);
			System.exit(0);

		} finally {
			return list;
		}
	}
	
	public int loginDB(String email,String pass){
		try (Connection conn = DBConnection.getCon()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select userEmailID,userPassword,userId from users where userEmailID='"+email);
			if(rs.next()) {
				if(rs.getString(1).equals(email) && rs.getString(2).equals(pass)) {
					return rs.getInt(3);
				}
			}
			else 
			{
				System.out.println("User not Found");
				System.exit(0);
				return 0;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0; 
	}
	
}
