import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Luke Arndt & Deborah Harrington
 * @date 23 August 2012
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
		connectionProperties.put("user", "mySQL-Database-Username");
		// Placeholder for real user name
		connectionProperties.put("password", "mySQL-Database-Password");
		// Placeholder for password
		connection = DriverManager.getConnection("mySQL-Database-URL",
				connectionProperties);

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
