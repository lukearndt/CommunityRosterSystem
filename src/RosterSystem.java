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
		// Generate a new connection object
		try {
			Database.init();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
