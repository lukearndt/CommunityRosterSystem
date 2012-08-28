import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

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
		
		int choice = 0;
		
		System.out.println("Connected!");
		
		while (choice != 6) {
			choice = menu();
		

		// Perform the Spike 2 activities.
		// TODO: Refactor spike 2 functionality so that it's better integrated
		// into the application
		Spike2Stuff spike2Stuff = new Spike2Stuff();

		try {
			spike2Stuff.insert();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		spike2Stuff.update();
		spike2Stuff.delete();
		spike2Stuff.select();
		}
		
		System.out.println("Goodbye");
	}
	
	public static int menu() {
		BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in));
		int menuChoice = 0;
		System.out.println("Choose from the following options: ");
		System.out.println("1: Print a list of members");
		System.out.println("2: Print Add a new member");
		System.out.println("3: Change details for a member");
		System.out.println("4: Delete a member");
		System.out.println("5: Find a member by name");
		System.out.println("6: Quit");
		while (true) {
            try {
                try {
                	menuChoice = Integer.parseInt(myReader.readLine().trim());
                } catch (IOException e) {
                	System.out.println(e.getMessage());
                }
                if (menuChoice < 1 || menuChoice > 6) {
                    System.out.println("Input value must be a valid integer between "
                            + 1 + " and " + 6 + ".");
                } else {
                    break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Input value must be a valid integer between " + 1
                        + " and " + 6 + ".");
            }
        }
		return menuChoice;
	}

}