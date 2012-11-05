package actions;
import java.sql.SQLException;
import java.util.HashMap;


import com.opensymphony.xwork2.ActionSupport;

public class AddCapability extends ActionSupport {
	
	private static final long serialVersionUID = 377183881071492080L;
	private String memberName;
	private String dutyName;
	private String message;
	private HashMap<String, Object> newCapabilityInformation = new HashMap<String, Object>();

	public String execute() {
		newCapabilityInformation.put("memberName", memberName);
		newCapabilityInformation.put("dutyName", dutyName);
		setNewCapability();
		//message = "The " + dutyName + " has been added for " + memberName + " successfully";
		return SUCCESS;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getDutyName() {
		return dutyName;
	}

	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setNewCapability() {
		try {
			RosterSystem.addCapability(newCapabilityInformation);
			message = "The " + dutyName + " duty has been added for " + memberName + " successfully";
		} catch (SQLException e) {
			message = "The details could not be found";
		}
	}
}
