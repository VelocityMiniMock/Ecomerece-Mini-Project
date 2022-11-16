package Main;

import java.util.ArrayList;
import java.util.Scanner;

import Products.DBConnection;
import Products.ProductDB;
import Products.ProductServices;
import Products.Products;
import cart.CartDB;
import orders.OrderDB;

public class Main {
	Scanner sc = new Scanner(System.in);
	

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Main m = new Main();
<<<<<<< HEAD
		CartDB db = new CartDB();
		System.out.println(db.findcartByuserId(3));
		
		
		
=======
		DBConnection db = new DBConnection();

		OrderDB o = new OrderDB();
		System.out.println(o.findordersByuserId(1));
>>>>>>> branch 'main' of https://github.com/VelocityMiniMock/Ecomerece-Mini-Project.git
		
	}

	public void loginMenu() {
		System.out.println("Please select correct option : ");
		System.out.println("Press 1 - To Login Existing User");
		System.out.println("Press 2 - To Register New User");
		System.out.print("Waiting for input : ");
		boolean watcher = false;
		do {
			switch (sc.nextInt()) {
			case 1:
				System.out.print("Login");
				login();
				watcher = false;
				break;
			case 2:
				System.out.print("Register");
				watcher = false;
				break;
			// After Register go to the
			default:
				System.out.print("Invalid Input !");
				watcher = true;
				break;
			}
		} while (watcher);

	}

	@SuppressWarnings("unused")
	public void login() {
		System.out.println("\n\t\t *** Welcome to Virtual Shop ***");
		System.out.print("Please enter your email address : ");
		String email = sc.next();
		System.out.print("Please enter your Password");
		String pass = sc.next();
		if (true) // login method from UserDB class
		{
			System.out.println("Login Successful");
			userMenu();
		} else {
			System.out.print("No User found with given details");
			loginMenu();
		}
	}

	public void userMenu() {
		System.out.println("\n\t\t *** Welcome Back to Virtual Shop ***");
		System.out.println("Please select correct option : ");
		System.out.println("Press 1 - To See User Profile");
		System.out.println("Press 2 - To Cart items ");
		System.out.println("Press 3 - Go to Purchase Menu ");
		System.out.println("Press 4 - View Order History ");
		System.out.print("Waiting for input : ");
		boolean watcher = true;
		do{
			switch (sc.nextInt()) {
			case 1:
				System.out.print("Profile view");watcher=false;
				break;
			case 2:
				System.out.print("Cart List");watcher=false;
				break;
			case 3:
				System.out.print("Purchase Menu");watcher=false;
				break;
			case 4:
				System.out.print("Order History");watcher=false;
				break;
			case 5:
				System.out.print("Logout User");loginMenu();watcher=false;
				break;
			default:
				System.out.print("Invalid Input !");watcher=true;
			}
		}while(watcher);
	}

}
