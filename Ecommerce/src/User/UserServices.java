package User;

import java.util.Scanner;

import Main.Main;

public class UserServices extends UserDB{
	public Main main = new  Main();
	Scanner sc = new Scanner(System.in);
	@SuppressWarnings("unused")
	public void login() {
		System.out.println("\n\t\t *** Welcome to Virtual Shop ***");
		System.out.print("Please enter your email address : ");
		String email = sc.next();
		System.out.print("Please enter your Password");
		String pass = sc.next();
		if (loginDB(email, pass)>0) // login method from UserDB class
		{
			System.out.println("Login Successful");
			userMenu();
		} else {
			System.out.print("No User found with given details");
			loginMenu();
		}
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
