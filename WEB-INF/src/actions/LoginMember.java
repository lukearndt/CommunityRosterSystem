package actions;


import com.opensymphony.xwork2.ActionSupport;

public class LoginMember extends ActionSupport {
	
	private static final long serialVersionUID = 377183881071492080L;
	private String password;
	private String email;
	private String message;

	public String execute() {
		message = checkLogin();
		return SUCCESS;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String checkLogin() {
		boolean validLogin = false;
		validLogin = RosterSystem.checkLogin(email, password);
		if (validLogin) {
			return "You have been successfully logged in";
		} else {
			return "You did not provide a valid log in. Try again - or go away!";
		}
	}
}
