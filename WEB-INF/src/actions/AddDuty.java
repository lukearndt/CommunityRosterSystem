package actions;
import java.util.HashMap;


import com.opensymphony.xwork2.ActionSupport;

public class AddDuty extends ActionSupport {
	
	private static final long serialVersionUID = 377183881071492080L;
	private String name;
	private String description;
	private String message;
	private HashMap<String, Object> newDutyInformation = new HashMap<String, Object>();

	public String execute() {
		newDutyInformation.put("name", name);
		newDutyInformation.put("description", description);
		setNewDuty();
		message = name + " has been added successfully";
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setNewDuty() {
		RosterSystem.addDuty(newDutyInformation);
	}
}
