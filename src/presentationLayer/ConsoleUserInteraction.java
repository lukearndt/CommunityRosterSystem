package presentationLayer;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import dataAccessLayer.Member;
import dataAccessLayer.Spike2Stuff;



/**
 * @author Luke Arndt & Deborah Harrington
 * @date 29 August 2012
 * 
 * 
 * 
 */

public class ConsoleUserInteraction {
	private Spike2Stuff spike2Stuff = new Spike2Stuff();
	private BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in));
	
	public void getList() {
		ArrayList<Member> memberList = new ArrayList<Member>();
		memberList = spike2Stuff.list();
		for (int i = 0; i<memberList.size(); i++) {
			System.out.println(memberList.get(i).getName() + ", " + 
								memberList.get(i).getAddress() + ", " + memberList.get(i).getSuburb() + " " + 
								memberList.get(i).getState() + " " + memberList.get(i).getPostCode());
		}
	}
	
	public void performInsert() {
		try {
			System.out.print("Enter the new member's name: ");
        	String name = myReader.readLine().trim();
        	System.out.print("Enter the new member's street address (don't include suburb, state or postcode): ");
        	String address = myReader.readLine().trim();
        	System.out.print("Enter the Suburb: ");
        	String suburb = myReader.readLine().trim();
        	System.out.print("Enter the State: ");
    		String state = myReader.readLine().trim();
        	System.out.print("Enter the Postcode: ");
    		String postCode = myReader.readLine().trim();
    		System.out.print("Enter the new member's home phone: ");
    		String homePhone = myReader.readLine().trim();
    		System.out.print("Enter the new member's mobile phone: ");
    		String mobilePhone = myReader.readLine().trim();
    		spike2Stuff.insert(name, address, suburb, state, postCode, homePhone, mobilePhone);
        } catch (IOException e) {
        	System.out.println(e.getMessage());
        }		
	}

	public void performUpdate() {
		try {
			System.out.print("Enter the name of the member whose address you wish to update: ");
        	String name = myReader.readLine().trim();
        	System.out.print("Enter the new member's street address (don't include suburb, state or postcode): ");
        	String address = myReader.readLine().trim();
        	System.out.print("Enter the Suburb: ");
        	String suburb = myReader.readLine().trim();
        	System.out.print("Enter the State: ");
    		String state = myReader.readLine().trim();
        	System.out.print("Enter the Postcode: ");
    		String postCode = myReader.readLine().trim();
    		spike2Stuff.update(name, address, suburb, state, postCode);		
        } catch (IOException e) {
        	System.out.println(e.getMessage());
        }
	}
	
	public void performDelete() {
		try {
			System.out.print("Enter the name of the member you wish to delete: ");
        	String name = myReader.readLine().trim();
        	spike2Stuff.delete(name);
        } catch (IOException e) {
        	System.out.println(e.getMessage());
        }		
	}
	
	public void performSelect() {
		ArrayList<Member> memberList = new ArrayList<Member>();
		try {
			System.out.print("Enter the name of the member you wish to view: ");
        	String name = myReader.readLine().trim();
        	memberList = spike2Stuff.select(name);
        } catch (IOException e) {
        	System.out.println(e.getMessage());
        }		
		
		for (int i = 0; i<memberList.size(); i++) {
			System.out.println(memberList.get(i).getName() + ", " + 
								memberList.get(i).getAddress() + ", " + memberList.get(i).getSuburb() + " " + 
								memberList.get(i).getState() + " " + memberList.get(i).getPostCode());
		}
	}
}
