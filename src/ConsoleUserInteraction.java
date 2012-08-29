import java.util.ArrayList;

/**
 * @author Luke Arndt & Deborah Harrington
 * @date 29 August 2012
 * 
 */

public class ConsoleUserInteraction {
	// Perform the Spike 2 activities.
	// TODO: Refactor spike 2 functionality so that it's better integrated
	// into the application
	public Spike2Stuff spike2Stuff = new Spike2Stuff();
	
	public void option1() {
		ArrayList<Member> memberList = new ArrayList<Member>();
		memberList = spike2Stuff.list();
		for (int i = 0; i<memberList.size(); i++) {
			System.out.println(memberList.get(i).getName() + ", " + 
								memberList.get(i).getAddress() + ", " + memberList.get(i).getSuburb() + " " + 
								memberList.get(i).getState() + " " + memberList.get(i).getPostCode());
		}
	}
	
	public void option2() {
		spike2Stuff.insert();		
	}

	public void option3() {
		spike2Stuff.update();		
	}
	
	public void option4() {
		spike2Stuff.delete();
	}

	public void option5() {
		spike2Stuff.select();
	}
}
