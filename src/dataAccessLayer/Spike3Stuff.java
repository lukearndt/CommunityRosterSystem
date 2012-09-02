package dataAccessLayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

public class Spike3Stuff {

	CachedRowSet myCachedRowSet;
	Statement myStatement;
	ResultSet myResultSet;

	public Spike3Stuff() throws SQLException {
		try {
			myCachedRowSet = new CachedRowSetImpl();
			myStatement = Database.getDatabaseConnection().createStatement();
			myResultSet = myStatement.executeQuery("SELECT * from member");
			myCachedRowSet.populate(myResultSet);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (myCachedRowSet != null) {
				myCachedRowSet.close();
			}
			if (myStatement != null) {
				myStatement.close();
			}
			if (myResultSet != null) {
				myResultSet.close();
			}
		}

		System.out.println("Selecting from table ["
				+ myCachedRowSet.getTableName() + "]");

		while (myCachedRowSet.next()) {
			System.out.println("Row number [" + myCachedRowSet.getRow() + "]");
		}
	}
}