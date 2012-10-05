import java.util.HashMap;

import actions.RosterSystem;

import com.opensymphony.xwork2.ActionSupport;

public class AddMember extends ActionSupport {
	
	private static final long serialVersionUID = 377183881071492080L;
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
		return message;
	}

	public void setNewMember(HashMap<String, Object> memberInformation) {
		RosterSystem.addMember(memberInformation);
	}
}
