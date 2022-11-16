package Products;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductServices extends ProductDB{

	private ArrayList<Products> plist = getProductList();
	private ArrayList<Products> cart = new ArrayList<Products>();
	private ProductDB db = new ProductDB();

	public ProductServices() {
		for (int i = 1; i < 11; i++) {
			//plist.add(new Products(i, "Product " + i, "Product" + 1 + " Description", i * 1000, i * 5));
			if(i%2==0) {
				cart.add(new Products(i, "Product " + i, "Product" + 1 + " Description", i * 1000, i * 5));
			}
		}
	}
	public void userProductList() {
		ArrayList<Products> list = getProductList();
		System.out.println("\t\t*** Available Product List ***\n");
		System.out.println(" PID\tProduct Name\tDescription/Category\t\tPrice");
		for (Products products : list) {
			System.out.printf("\n %-5d  %-15s %-30s  %f ", products.getProductID(), products.getName(),
					products.getDescription(), products.getPrice());
		}
	}
	
	public void billCounterProductList(ArrayList<Products> cart) {
		System.out.println("\t\t*** Selected Product List ***\n");
		System.out.println(" PID\tProduct Name\tPrice\t\tQuantity");
		float total = 0;
		for (Products products : cart) {
			total=(total+(products.getPrice()*products.getQuantity()));
			System.out.printf("\n %-5d  %-15s  %-15f %d", products.getProductID(), products.getName(),
					products.getPrice(), products.getQuantity());
		}
		System.out.println("\n\t\t\t\tTotal Amount\t"+total);
	}
	public void billCounterProductList(Products products) {
		System.out.println("\t\t*** Selected Product List ***\n");
		System.out.println(" PID\tProduct Name\tPrice\t\tQuantity");
		float total = 0;
			total=(total+(products.getPrice()*products.getQuantity()));
			System.out.printf("\n %-5d  %-15s  %-15f %d", products.getProductID(), products.getName(),
					products.getPrice(), products.getQuantity());
		System.out.println("\n\t\t\t\tTotal Amount\t"+total);
	}

	public void adminProductList(ArrayList<Products> list) {
		System.out.println("\t\t\t*** Available Product List ***\n");
		System.out.println(" PID\tProduct Name\tDescription/Category\t\tPrice\t\tStock");
		for (Products products : list) {
			System.out.printf("\n %-5d  %-15s %-30s  %-15f %d", products.getProductID(), products.getName(),
					products.getDescription(), products.getPrice(), products.getQuantity());
		}
	}

	public void addProduct() {
		try (Scanner sc = new Scanner(System.in)) {
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
			db.productRegister(product);			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void productSelector(int uid) {
		try (Scanner sc = new Scanner(System.in)) {
			userProductList();
			System.out.print("\n\nTo select Product Enter ProductID(PID) : ");
			int pid = sc.nextInt();
			if (isProductAvailable(pid)) {
				System.out.println("----------------------Menu----------------------");
				System.out.println("Press 1 - To Buy Product");
				System.out.println("Press 2 - To Add Product in cart");
				System.out.print("Waiting for input : ");
				boolean watcher = true;
				do {
					switch (sc.nextInt()) {
					case 1:
						buyProduct(uid, pid);
						watcher = false;
						break;
					case 2:
						addToCart(uid,pid);
						watcher = false;
						break;
					default:
						watcher = true;
						System.out.println("Invalid Input, Please try Again ");
						System.out.print("Waiting for input : ");								
						break;
					}
				} while (watcher);
				System.out.println("\n\nDo You want to continue Shopping? (Yes/No)");
				if("yes".compareToIgnoreCase(sc.nextLine()) > 0) {
					productSelector(uid);
				}else if("no".compareToIgnoreCase(sc.nextLine()) > 0){
					System.out.println("main Menu");
				}else {
					System.out.println("Invalid Input");
				}
			}

		}
	}

	public boolean isProductAvailable(int id) {
		return super.isProductAvailable(id);
	}
	
	public Object findProductsById(int id) {
		return super.findProductsById(id);
	}
	
	public void buyProduct(int userId, int productId) {
		System.out.println("*** Welcome to Billing Counter ***");
		System.out.println("User Name : ");
		System.out.println("User Email : \n");
		billCounterProductList(cart);
		System.out.println("\nPayment Type : Cash On Delivery");
		System.out.println("Your Order will deliver soon on your address");
		System.out.println("Thanks for doing business with us");
	}

	public void addToCart(int userId, int productId) {
		cart.add((Products) findProductsById(productId));
		System.out.println("Product is added to Cart");
	}

}
