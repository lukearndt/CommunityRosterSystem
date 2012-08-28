import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Luke Arndt & Deborah Harrington
 * @date 23 August 2012
 * 
 *       This class is intended to function on a static basis, accessible to the
 *       other classes in the solution. It handles the actual connection object
 *       for the database.
 */
public class Database {

	private static Connection connection;

	/**
	 * Creates a connection object and prepares it for use by the rest of the
	 * application
	 * 
	 * @throws SQLException
	 */
	public static void init() throws SQLException {
		// Call the createConnection method to generate our connection
		setConnection(createConnection());
	}

	/**
	 * Generates and returns a connection object for us to work with
	 * 
	 * @return Connection connection
	 * @throws SQLException
	 */
	private static Connection createConnection() throws SQLException {
		// Generate a new connection object 
		Connection connection = null;
		Properties connectionProperties = new Properties();
		connectionProperties.put("user", "SystemUser");
		connectionProperties.put("password", "lk7^t5$FbN3$");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/duty_roster", connectionProperties);
		return connection;
	}

	/**
	 * @return the connection
	 */
	public static Connection getDatabaseConnection() {
		if (connection == null) {
			throw new RuntimeException(
					"Called Database.getDatabaseConnection() without an existing database connection.");
		}
		return connection;
	}

	/**
	 * @param connection
	 *            the connection to set
	 */
	private static void setConnection(Connection connection) {
		Database.connection = connection;
	}
}
