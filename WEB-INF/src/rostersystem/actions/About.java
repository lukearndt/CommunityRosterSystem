package rostersystem.actions;

import com.opensymphony.xwork2.ActionSupport;

public class About extends ActionSupport {
	
	private static final long serialVersionUID = 178603278604L;
	public static final String MESSAGE = "Struts is up and running ...";

	public String execute() throws Exception {
		setMessage(MESSAGE);
		return SUCCESS;
	}

	private String message = "Ok";

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}