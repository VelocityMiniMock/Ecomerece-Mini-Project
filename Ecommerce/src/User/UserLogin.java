package User;
import java.util.Scanner;

public class UserLogin {
	public static void main(String[] args) {
		
		Users urd=new Users();
		
		System.out.println("------WELCOME TO ECOMMERCE------");
		System.out.println("----Login Your Account----");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Email ID");
		urd.setEmailID(sc.nextLine());
		System.out.println("Entre Password");
		urd.setPassword(sc.nextLine());
		//if password && EmailID matches
		System.out.println("Hi"+urd.getUserName());
		//if password/EmailID not matches
		System.out.println("Incorrect EmailID/Password");
		//if password && EmailID not matches
		System.out.println("Please Register Your Account");

}
}
