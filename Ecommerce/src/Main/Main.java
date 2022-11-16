package Main;

import java.util.ArrayList;
import java.util.Scanner;

import Products.DBConnection;
import Products.ProductDB;
import Products.ProductServices;
import Products.Products;
import User.UserServices;
import cart.CartDB;
import orders.OrderDB;

public class Main {
	Scanner sc = new Scanner(System.in);
		@SuppressWarnings("static-access")
	public static void main(String[] args) {
		UserServices  userServices = new UserServices();
		userServices.loginMenu();
	}
}
