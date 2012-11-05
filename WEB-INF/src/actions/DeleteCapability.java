package actions;
import java.util.HashMap;


import com.opensymphony.xwork2.ActionSupport;

public class DeleteCapability extends ActionSupport {
	
	private static final long serialVersionUID = 377183881071492080L;
	private String memberName;
	private String dutyName;
	private String message;
	private HashMap<String, Object> capabilityInformation = new HashMap<String, Object>();

	public String execute() {
		capabilityInformation.put("memberName", memberName);
		capabilityInformation.put("dutyName", dutyName);
		deleteCapability();
		message = "The " + dutyName + " has been deleted for " + memberName + " successfully";
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

	public void deleteCapability() {
		RosterSystem.deleteCapability(capabilityInformation);
	}
}
