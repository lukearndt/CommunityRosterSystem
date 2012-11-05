package actions;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteDuty extends ActionSupport {
	
	private static final long serialVersionUID = 377183881071492080L;
	private String name;
	private String message;

	public String execute() {
		deleteDuty();
		message = name + " has been deleted successfully";
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	private void deleteDuty() {
		RosterSystem.deleteDuty(name);
	}
}
