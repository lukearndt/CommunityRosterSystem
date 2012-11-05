package actions;
import java.util.ArrayList;
import java.util.List;

import models.Capability;
import models.Duty;

import com.opensymphony.xwork2.ActionSupport;

public class MemberCapabilities extends ActionSupport {
	
	private static final long serialVersionUID = 377183881071492080L;
	private String name;
	private String message;

	public String execute() {
		message = "These are the capabilities for " + name + ":";
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
	
	public List<String> getMemberCapabilities() {
		List<String> myMemberCapabilities = new ArrayList<String>();
		for(Capability c : RosterSystem.findMemberCapabilities(name))
		{
			Duty myDuty = RosterSystem.findDutyByID(c.getDuty_ID());
			myMemberCapabilities.add(myDuty.getName());
		}
		
		return myMemberCapabilities; 
	}
}
