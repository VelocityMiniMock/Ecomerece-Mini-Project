package User;
import java.util.Scanner;

public class UserRegitration {
public static void main(String[] args) {
		
		UserRegistrationDetails urd=new UserRegistrationDetails();
		
		System.out.println("------WELCOME TO ECOMMERCE------");
		System.out.println("----New Regitration----");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter User Name");
		urd.setUserName(sc.nextLine());
		System.out.println("Enter Mobile Number");
		urd.setMobileNumber(sc.nextLine());
		System.out.println("Enter Email ID");
		urd.setEmailID(sc.nextLine());
		System.out.println("Create Password");
		urd.setPassword(sc.nextLine());
		System.out.println("Verify Password");
		urd.setVerifypassword(sc.nextLine());
		if(urd.getPassword().equals(urd.getVerifypassword())) { 
			System.out.println("Your Registration is Successful");
		}else {
			System.out.println("Please Enter correct Password");
		}
		
		System.out.println("Enter Address");
		urd.setAddress(sc.next());
		System.out.println("Your Address has been saved successfully");
		System.out.println("---Thank you for choosing us---");
	}


}
