package persistanceLayer;

/**
 * @author Luke Arndt & Deborah Harrington
 * 
 */
public abstract class DataRepositoryFactory {

	private static final String DATA_ACCESS_MODE = "ActiveJdbc";

	public static IDataRepository getDataAccess() {
		IDataRepository dataManager = null;

		if (DATA_ACCESS_MODE.equals("ActiveJdbc")) {

			dataManager = new ActiveJdbcDataRepository();

		}
		return dataManager;
	}
}
