package dataAccessLayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import com.sun.rowset.CachedRowSetImpl;

public class Spike3Stuff {

	CachedRowSetImpl myCachedRowSet;
	Statement myStatement;
	ResultSet myResultSet;

	public Spike3Stuff() throws SQLException {
		try {
			myCachedRowSet = new CachedRowSetImpl();
			// myStatement = Database.getDatabaseConnection().createStatement();
			// myResultSet = myStatement.executeQuery("SELECT * from member");
			myCachedRowSet.setCommand("SELECT * FROM member");
			Database.getDatabaseConnection().setAutoCommit(false);
			myCachedRowSet.execute(Database.getDatabaseConnection());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("Selecting from table ["
				+ myCachedRowSet.getTableName() + "]");

		// Display our current member data
		while (myCachedRowSet.next()) {
			System.out.println("Row number [" + myCachedRowSet.getRow()
					+ "], id [" + myCachedRowSet.getInt("id") + "], name ["
					+ myCachedRowSet.getString("name") + "], address ["
					+ myCachedRowSet.getString("address") + "], phone number ["
					+ myCachedRowSet.getString("phone_number") + "]");
		}

		Random myRandom = new Random();
		// Insert a row
		myCachedRowSet.moveToInsertRow();
		myCachedRowSet.updateInt("id", myRandom.nextInt() & 0x7FFFFFFF);
		myCachedRowSet.updateString("name", "newest derp on the block");
		myCachedRowSet.updateString("address",
				(myRandom.nextInt() & 0x7FFFFFFF) + " privett drive");
		myCachedRowSet.updateString("phone_number",
				Integer.toString(myRandom.nextInt() & 0x7FFFFFFF));
		try {
			myCachedRowSet.insertRow();
		} catch (SQLException e) {
			System.out.println("Duplicate key or something. Row not inserted.");
		}
		// Move the cursor back to the current row
		myCachedRowSet.moveToCurrentRow();
		myCachedRowSet.acceptChanges(Database.getDatabaseConnection());

		System.out.println("Row inserted!");
		// Display our current member data
		while (myCachedRowSet.next()) {
			System.out.println("Row number [" + myCachedRowSet.getRow()
					+ "], id [" + myCachedRowSet.getInt("id") + "], name ["
					+ myCachedRowSet.getString("name") + "], address ["
					+ myCachedRowSet.getString("address") + "], phone number ["
					+ myCachedRowSet.getString("phone_number") + "]");
		}

		if (myStatement != null) {
			myStatement.close();
		}
		if (myResultSet != null) {
			myResultSet.close();
		}
		if (myCachedRowSet != null) {
			myCachedRowSet.close();
		}
	}
}