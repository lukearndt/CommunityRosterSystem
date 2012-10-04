package models;


/**
 * @author Luke Arndt & Deborah Harrington
 * 
 */
public abstract class DbDetails  {

	private static final String PASSWORD = "lk7^t5$FbN3$";
	private static final String USER_NAME = "SystemUser";
	protected static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3307/duty_roster";
	/**
	 * @return the databaseUrl
	 */
	public static String getDatabaseUrl() {
		return DATABASE_URL;
	}
	/**
	 * @return the userName
	 */
	public static String getUserName() {
		return USER_NAME;
	}
	/**
	 * @return the password
	 */
	public static String getPassword() {
		return PASSWORD;
	}

}
 