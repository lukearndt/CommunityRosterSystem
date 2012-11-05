package actions;

import java.util.ArrayList;
import java.util.List;

import models.Duty;

import com.opensymphony.xwork2.ActionSupport;

public class DutyManagement extends ActionSupport {

	private static final long serialVersionUID = 8509078543326488295L;

	public String execute() {
		return SUCCESS;
	}

	public List<String> getDutyDetails() {
		List<String> myDutyList = new ArrayList<String>();
		for(Duty d : RosterSystem.getDutyList())
		{
			myDutyList.add(d.getName() + " " + d.getDescription());			
		}
		
		return myDutyList; 
	}
}