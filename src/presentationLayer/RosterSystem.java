package presentationLayer;

import java.sql.SQLException;

import dataAccessLayer.Database;
import dataAccessLayer.Spike3Stuff;

/**
 * @author Luke Arndt & Deborah Harrington
 * @date 23 August 2012
 * 
 */
public class RosterSystem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Initialize our data access layer
		try {
			Database.init();
		} catch (SQLException e) {
			System.err
					.println("Failed to initialize data access layer. Reason: "
							+ e.getMessage());
			System.err.println("Error code: " + e.getErrorCode());
		}

		/*
		 * try { String command = args[0];
		 * 
		 * ConsoleUserInteraction consoleUserInteraction = new
		 * ConsoleUserInteraction();
		 * 
		 * if (command.equals("insert")) {
		 * consoleUserInteraction.performInsert(); } else if
		 * (command.equals("update")) { consoleUserInteraction.performUpdate();
		 * } else if (command.equals("delete")) {
		 * consoleUserInteraction.performDelete(); } else if
		 * (command.equals("list")) { consoleUserInteraction.getList(); } else
		 * if (command.equals("find")) { consoleUserInteraction.performSelect();
		 * } else { System.out.println(
		 * "You didn't enter a recognised command. The following are valid commands: "
		 * +
		 * "insert, update, delete, list, find. Run the program again with a valid command"
		 * ); }
		 * 
		 * 
		 * } catch (ArrayIndexOutOfBoundsException e) { System.out.println(
		 * "You did not specifiy a command for the program to carry out");
		 * System.out.println(e.getMessage()); }
		 */

		try {
			@SuppressWarnings("unused")
			Spike3Stuff mySpike3 = new Spike3Stuff();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}