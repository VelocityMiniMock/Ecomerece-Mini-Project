package User;

public class UserRegistrationDetails {
	private String userName;
	private String mobileNumber;
	private String emailID;
	private String password;
	private String verifypassword;
	private int pincode;
	private String address;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumbe) {
		this.mobileNumber = mobileNumbe;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVerifypassword() {
		return verifypassword;
	}
	public void setVerifypassword(String verifypassword) {
		this.verifypassword = verifypassword;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
