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

		// Perform the Spike 2 activities.
		// TODO: Refactor spike 2 functionality so that it's better integrated
		// into the application
		Spike2Stuff spike2Stuff = new Spike2Stuff();

		spike2Stuff.insert();
		spike2Stuff.update();
		spike2Stuff.delete();
		spike2Stuff.select();
	}

}
