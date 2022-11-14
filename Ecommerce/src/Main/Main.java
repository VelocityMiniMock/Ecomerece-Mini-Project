package Main;

import java.util.ArrayList;
import java.util.Scanner;

import Products.DBConnection;
import Products.ProductServices;
import Products.Products;

public class Main {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Main m = new Main();
		DBConnection db = new DBConnection();
		ProductServices services = new ProductServices();
		//services.createProductTable();
		//services.addDummyList();
		//services.userProductList();
		System.out.println(services.findProductsById(80));
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
