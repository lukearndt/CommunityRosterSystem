package views;

import java.util.HashMap;

import controllers.RosterSystem;

/**
 * @author Luke Arndt & Deborah Harrington
 * @date 29 August 2012
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

	private void processMainMenu(int mainMenuResponse)
	{
		switch (mainMenuResponse)
		{
		case 1:
			RosterSystem.addMember(presentAddMemberQuery());
		}
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

	protected int presentMainMenu()
	{
		IO.say("-------------------------------------------");
		IO.say("| Member Management Menu                  |");
		IO.say("-------------------------------------------");
		IO.say("| 1 - add a member                        |");
		IO.say("| 2 - delete a member                     |");
		IO.say("| 3 - list all members                    |");
		IO.say("| 4 - save and return		              |");
		IO.say("-------------------------------------------");

		return IO.getInt(
				"Please make a selection from one of the above options", 1, 4);
	}
}
