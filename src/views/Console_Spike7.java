package views;

import controllers.IO;
import controllers.RosterSystem;

/**
 * @author Luke Arndt & Deborah Harrington
 * @date 10 October 2012
 * 
 */

public class Console_Spike7 {

	public Console_Spike7() {
		int memberID = IO.getInt("What is the ID of the member that is buying a book?", 1, 3);
		int bookID = IO.getInt("Which number book are they buying?", 1, 4);
		int quantity = IO.getInt("How many copies of the book are they buying?", 1, 500);
		String message = RosterSystem.processMemberPurchases(memberID, bookID, quantity);
		System.out.println(message);
	}
}