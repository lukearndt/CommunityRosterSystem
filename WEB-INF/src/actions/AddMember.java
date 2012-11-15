package actions;
import java.util.HashMap;


import com.opensymphony.xwork2.ActionSupport;

public class AddMember extends ActionSupport {
	
	private static final long serialVersionUID = 377183881071492080L;
	private String name;
	private String address;
	private String suburb;
	private String state;
	private String postCode;
	private String home_Phone;
	private String mobile_Phone;
	private String email;
	private String password;
	private String message;
	private HashMap<String, Object> newMemberInformation = new HashMap<String, Object>();

	public String execute() {
		newMemberInformation.put("name", name);
		newMemberInformation.put("address", address);
		newMemberInformation.put("suburb", suburb);
		newMemberInformation.put("state", state);
		newMemberInformation.put("postCode", postCode);
		newMemberInformation.put("home_Phone", home_Phone);
		newMemberInformation.put("mobile_Phone", mobile_Phone);
		newMemberInformation.put("email", email);
		newMemberInformation.put("password", password);
		setNewMember();
		message = name + " has been added successfully";
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getHome_Phone() {
		return home_Phone;
	}

	public void setHome_Phone(String home_Phone) {
		this.home_Phone = home_Phone;
	}

	public String getMobile_Phone() {
		return mobile_Phone;
	}

	public void setMobile_Phone(String mobile_Phone) {
		this.mobile_Phone = mobile_Phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setNewMember() {
		RosterSystem.addMember(newMemberInformation);
	}
}
