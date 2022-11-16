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
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Main m = new Main();
		CartDB db = new CartDB();
		System.out.println(db.findcartByuserId(3));
		
		
		
		
	}
	
	public Products addProduct() {
		try (Scanner sc = new Scanner(System.in))
		{
			Products product = new Products();
			System.out.println("*** Product Details ****");
			System.out.print("Enter Product Name :");
			product.setName(sc.nextLine());
			System.out.print("Enter Product Description(Say : Category): ");
			product.setDescription(sc.nextLine());
			System.out.print("Enter Product Price :");
			product.setPrice(sc.nextInt());
			System.out.print("Enter Product Stock qunatity(Units): ");
			product.setQuantity(sc.nextInt());
			return product;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}	
