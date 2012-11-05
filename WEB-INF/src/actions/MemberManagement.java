package actions;

import java.util.ArrayList;
import java.util.List;

import models.Member;

import com.opensymphony.xwork2.ActionSupport;

public class MemberManagement extends ActionSupport {

	private static final long serialVersionUID = 5503309919904233051L;

	public String execute() {
		return SUCCESS;
	}

	public List<String> getMemberDetails() {
		List<String> myMemberList = new ArrayList<String>();
		for (Member m : RosterSystem.getMemberList()) {
			myMemberList.add(m.getName() + " " + m.getAddress());
		}

		return myMemberList;
	}
}