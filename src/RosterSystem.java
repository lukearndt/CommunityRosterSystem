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
		
		ConsoleUserInteraction consoleUserInteraction = new ConsoleUserInteraction();
		
		int choice = 0;
		
		System.out.println("Connected!");
		
		// run the menu and get a menu choice from the user until they choose to exit the program
		while (choice != 6) {
			choice = menu();
		
			switch (choice) {
			case 1: consoleUserInteraction.option1();
			case 2: consoleUserInteraction.option2();
			case 3: consoleUserInteraction.option3();
			case 4: consoleUserInteraction.option4();
			case 5: consoleUserInteraction.option5();
			}
		}
		System.out.println("Goodbye");
	}
	
	public static int menu() {
		BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in));
		int menuChoice = 0;
		System.out.println("");
		System.out.println("Choose from the following options: ");
		System.out.println("1: Print a list of members");
		System.out.println("2: Add a new member");
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