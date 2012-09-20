package views;

import java.util.HashMap;


import models.Capabilities;
import models.Duty;
import models.Member;

import org.javalite.activejdbc.LazyList;

import controllers.RosterSystem;



/**
 * @author Luke Arndt & Deborah Harrington
 * @date 20 September 2012
 * 
 * 
 *
 */

public class Console
{
	public Console()
	{
		processMainMenu(presentMainMenu());
	}
	
	private int presentMainMenu() {
		IO.say("---------------------------------------------");
		IO.say("| Main Menu                                 |");
		IO.say("---------------------------------------------");
		IO.say("| 1 - go the member management menu         |");
		IO.say("| 2 - go to the duty management menu        |");
		IO.say("| 3 - go the the capability management menu |");
		IO.say("| 4 - exit the system                       |");
		IO.say("---------------------------------------------");
		return IO.getInt(
				"Please make a selection from one of the above options", 1, 4);
	}

	private void processMainMenu(int mainMenuResponse) {
		switch (mainMenuResponse)
		{
		case 1:
			processMemberManagementMenu(presentMemberManagementMenu());
		case 2:
			processDutyManagementMenu(presentDutyManagementMenu());
		case 3:
			processCapabilityManagementMenu(presentCapabilityManagementMenu());
		case 4:
			System.exit(0);
		}
		
	}
	
	protected int presentMemberManagementMenu()
	{
		IO.say("-------------------------------------------");
		IO.say("| Member Management Menu                  |");
		IO.say("-------------------------------------------");
		IO.say("| 1 - add a member                        |");
		IO.say("| 2 - update a member                     |");
		IO.say("| 3 - delete a member                     |");
		IO.say("| 4 - list all members                    |");
		IO.say("| 5 - get capabilities for a member       |");
		IO.say("| 6 - return to the main menu             |");
		IO.say("-------------------------------------------");

		return IO.getInt(
				"Please make a selection from one of the above options", 1, 6);
	}
	
	private void processMemberManagementMenu(int memberMenuResponse)
	{
		switch (memberMenuResponse)
		{
		case 1:
			RosterSystem.addMember(presentAddMemberQuery());
		case 2:
			RosterSystem.updateMember(IO.getString("Enter the name of the member you wish to update: ",  false,  true), presentUpdateMemberQuery());
		case 3:
			RosterSystem.deleteMember(presentMemberToDeleteQuery());
		case 4:
			printMemberList(RosterSystem.getMemberList());
		case 5:
			printCapabilities(RosterSystem.findMemberCapabilities(IO.getString("Enter the name of the member for whom you wish to view capabilities: ", false, true)));
		case 6:
			processMainMenu(presentMainMenu());
		}
	}
	
	private int presentCapabilityManagementMenu() {
		IO.say("-------------------------------------------");
		IO.say("| Capability Management Menu              |");
		IO.say("-------------------------------------------");
		IO.say("| 1 - add a capability                    |");
		IO.say("| 2 - delete a capability                 |");
		IO.say("| 3 - return to the main menu             |");
		IO.say("-------------------------------------------");

		return IO.getInt(
				"Please make a selection from one of the above options", 1, 3);
	}

	private void processCapabilityManagementMenu(
			int capabilityMenuResponse) {
		switch (capabilityMenuResponse)
		{
		case 1:
			// add an existing duty to an existing member - ask the user for duty name and member name
			RosterSystem.addCapability(getCapabilityInformation());
		case 2:
			// delete capability - ask the user for duty name and member name
			RosterSystem.deleteCapability(getCapabilityInformation());
		case 3:
			processMainMenu(presentMainMenu());
		}
		
	}

	private int presentDutyManagementMenu() {
		IO.say("-------------------------------------------");
		IO.say("| Duty Management Menu                    |");
		IO.say("-------------------------------------------");
		IO.say("| 1 - add a duty                          |");
		IO.say("| 2 - update a duty                       |");
		IO.say("| 3 - delete a duty                       |");
		IO.say("| 4 - list all duties                     |");
		IO.say("| 5 - get capabilities for a duty         |");
		IO.say("| 6 - return to the main menu             |");
		IO.say("-------------------------------------------");

		return IO.getInt(
				"Please make a selection from one of the above options", 1, 6);
	}

	private void processDutyManagementMenu(int dutyMenuResponse) {
		switch (dutyMenuResponse)
		{
		case 1:
			RosterSystem.addDuty(presentAddDutyQuery());
		case 2:
			RosterSystem.updateDuty(IO.getString("Enter the name of the duty you wish to update: ",  false,  true), presentUpdateDutyQuery());
		case 3:
			RosterSystem.deleteDuty(presentDutyToDeleteQuery());
		case 4:
			printDutyList(RosterSystem.getDutyList());
		case 5:
			printCapabilities(RosterSystem.findDutyCapabilities(IO.getString("Enter the name of the duty for which you wish to view capabilities", false, true)));
		case 6:
			processMainMenu(presentMainMenu());
		}
	}

	private HashMap<String, Object> presentUpdateMemberQuery() {
		IO.say("------------------------------------------");
		IO.say("| Update Member                           |");
		IO.say("------------------------------------------");

		HashMap<String, Object> memberInformation = new HashMap<String, Object>();

		memberInformation.put("name",IO.getString("Please enter a new value for Name", false, true));
		memberInformation.put("address",IO.getString("Please enter a new value for Address", false, false));
		memberInformation.put("suburb",IO.getString("Please enter a new value for Suburb", false, false));
		memberInformation.put("state",IO.getString("Please enter a new value for State", false, false));
		memberInformation.put("postcode",IO.getString("Please enter a new value for Postcode", false, false));
		memberInformation.put("homePhone",IO.getString("Please enter a new value for Home Phone", false, false));
		memberInformation.put("mobilePhone",IO.getString("Please enter a new value for Mobile Phone", false, false));
		memberInformation.put("spouseName",IO.getString("Please enter a new value for Spouse Name", false, false));

		return memberInformation;
	}

	private void printMemberList(LazyList<Member> memberList) {
		for (int i = 0; i < memberList.size(); i++) { 
			System.out.println(memberList.get(i).toString());
		}
	}

	private String presentMemberToDeleteQuery() {
		IO.say("-------------------------------------------");
		IO.say("| Delete Member                           |");
		IO.say("-------------------------------------------");
		return IO.getString("Please enter the name of the member that you wish to delete", false, true);
	}

	private HashMap<String, Object> presentAddMemberQuery()
	{
		IO.say("-------------------------------------------");
		IO.say("| Add Member                              |");
		IO.say("-------------------------------------------");
		IO.say("| You will be prompted to enter the       |");
		IO.say("| following information:                  |");
		IO.say("|                                         |");
		IO.say("| Name	(Required)	                      |");
		IO.say("| Address   				              |");
		IO.say("| Suburb    				              |");
		IO.say("| State     				              |");
		IO.say("| Postcode   				              |");
		IO.say("| Home Phone   				              |");
		IO.say("| Mobile Phone 				              |");
		IO.say("| Spouse Name  				              |");
		IO.say("-------------------------------------------");

		HashMap<String, Object> memberInformation = new HashMap<String, Object>();

		memberInformation.put("name",IO.getString("Please enter a value for Name", false, true));
		memberInformation.put("address",IO.getString("Please enter a value for Address", false, false));
		memberInformation.put("suburb",IO.getString("Please enter a value for Suburb", false, false));
		memberInformation.put("state",IO.getString("Please enter a value for State", false, false));
		memberInformation.put("postcode",IO.getString("Please enter a value for Postcode", false, false));
		memberInformation.put("homePhone",IO.getString("Please enter a value for Home Phone", false, false));
		memberInformation.put("mobilePhone",IO.getString("Please enter a value for Mobile Phone", false, false));
		memberInformation.put("spouseName",IO.getString("Please enter a value for Spouse Name", false, false));

		return memberInformation;
	}
	
	private void printDutyList(LazyList<Duty> dutyList) {
		for (int i = 0; i < dutyList.size(); i++) { 
			System.out.println(dutyList.get(i).toString());
		}		
	}

	private String presentDutyToDeleteQuery() {
		IO.say("-------------------------------------------");
		IO.say("| Delete Duty                             |");
		IO.say("-------------------------------------------");
		return IO.getString("Please enter the name of the duty that you wish to delete", false, true);
	}

	private HashMap<String, Object> presentUpdateDutyQuery() {
		IO.say("------------------------------------------");
		IO.say("| Update Duty 							 |");
		IO.say("------------------------------------------");

		HashMap<String, Object> dutyInformation = new HashMap<String, Object>();

		dutyInformation.put("name",IO.getString("Please enter a new value for Name", false, true));
		dutyInformation.put("description",IO.getString("Please enter a new value for Description", false, false));
		
		return dutyInformation;
	}

	private HashMap<String, Object> presentAddDutyQuery() {
		IO.say("-------------------------------------------");
		IO.say("| Add Duty								  |");
		IO.say("-------------------------------------------");
		IO.say("| You will be prompted to enter the       |");
		IO.say("| following information:                  |");
		IO.say("|                                         |");
		IO.say("| Name	(Required)	                      |");
		IO.say("| Description							  |");
		IO.say("-------------------------------------------");

		HashMap<String, Object> dutyInformation = new HashMap<String, Object>();

		dutyInformation.put("name",IO.getString("Please enter a value for Name", false, true));
		dutyInformation.put("description",IO.getString("Please enter a value for Description", false, false));

		return dutyInformation;
	}
	
	private HashMap<String, Object> getCapabilityInformation() {
		HashMap<String, Object> capabilityInformation = new HashMap<String, Object>();

		capabilityInformation.put("memberName",IO.getString("Please enter the member name", false, true));
		capabilityInformation.put("dutyName",IO.getString("Please enter the duty name", false, false));
		
		return capabilityInformation;		
	}
	
	private void printCapabilities(LazyList<Capabilities> capabilities) {
		for (int i = 0; i < capabilities.size(); i++) { 
			System.out.println(capabilities.get(i).toString());
		}
	}
}