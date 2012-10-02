package rostersystem.actions;

import com.opensymphony.xwork2.ActionSupport;

public class Index extends ActionSupport {

	private static final long serialVersionUID = 8509078543326488295L;
	private String message;
	private String cool = "cool story bro";

	public String getCool() {
		return cool;
	}

	public String getMessage() {
		return message;
	}

	public String execute() {
		message = "Hello World!";
		return SUCCESS;
	}
}
