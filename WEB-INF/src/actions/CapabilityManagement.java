package actions;

import java.util.ArrayList;
import java.util.List;

import models.Member;

import com.opensymphony.xwork2.ActionSupport;

public class CapabilityManagement extends ActionSupport {

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

	public List<String> getMemberDetails() {
		List<String> myMemberList = new ArrayList<String>();
		for(Member m : RosterSystem.getMemberList())
		{
			myMemberList.add(m.getName() + " " + m.getAddress());			
		}
		
		return myMemberList; 
	}
}