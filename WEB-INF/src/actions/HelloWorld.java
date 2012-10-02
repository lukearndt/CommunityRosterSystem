package actions;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorld extends ActionSupport {
	private static final long serialVersionUID = 4466576904807045268L;
	private String message;

	public String getCool() {
		return "AWESOME";
	}

	public String getMessage() {
		return message;
	}

	public String execute() {
		message = "Hello World!";
		return SUCCESS;
	}
}
