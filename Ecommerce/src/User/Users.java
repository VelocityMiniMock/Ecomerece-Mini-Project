package User;

public class Users {
	private String userName;
	private String mobileNumber;
	private String emailID;
	private String password;
	private String verifypassword;
	private String address;
	private int userID;
	
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
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public Users(int userID,String userName, String mobileNumber, String emailID, String password, String address) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.mobileNumber = mobileNumber;
		this.emailID = emailID;
		this.password = password;
		this.address = address;
	}
	public Users(String userName, String mobileNumber, String emailID, String password,String address) {
	super();
	
	this.userName = userName;
	this.mobileNumber = mobileNumber;
	this.emailID = emailID;
	this.password = password;
	this.address = address;
}
	public Users() {
		
	}
}
