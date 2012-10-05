package actions;
import java.util.HashMap;


import com.opensymphony.xwork2.ActionSupport;

public class AddMember extends ActionSupport {
	
	private static final long serialVersionUID = 377183881071492080L;
	// add lots of new variables to receive info from the user.
	private String userName;
	private String message;

	public String execute() {
		message = "Welcome " + userName;
		return SUCCESS;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserName() {
		return userName;
	}

	public String getMessage() {
		// add stuff here to place the data into a hashmap?
		return message;
	}

	public void setNewMember(HashMap<String, Object> memberInformation) {
		RosterSystem.addMember(memberInformation);
	}
}
