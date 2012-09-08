package dataAccessLayer;

/**
 * @author Luke Arndt & Deborah Harrington
 * 
 */
public abstract class DataAccessFactory {

	private static final String DATA_ACCESS_MODE = "ActiveJdbc";

	public static IDataAccess getDataAccess() {
		IDataAccess dataManager = null;

		if (DATA_ACCESS_MODE.equals("ActiveJdbc")) {

			dataManager = new ActiveJdbcDataManager();

		}
		return dataManager;
	}
}
