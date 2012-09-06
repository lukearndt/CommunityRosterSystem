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
		System.out.println("Once upon a time . . . ");
		try {
			myCachedRowSet = new CachedRowSetImpl();
			myCachedRowSet.setCommand("SELECT * FROM member");
			Database.getDatabaseConnection().setAutoCommit(false);
			myCachedRowSet.execute(Database.getDatabaseConnection());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("Selecting from table ["
				+ myCachedRowSet.getTableName() + "]");

		// Display our current member data
		printList();

		Random myRandom = new Random();
		// Insert a row
		myCachedRowSet.moveToInsertRow();
		myCachedRowSet.updateInt("id", 0);
		myCachedRowSet.updateString("name", "newest derp on the block");
		myCachedRowSet.updateString("address",
				(myRandom.nextInt() & 0x7FFFFFFF) + " privett drive");
		myCachedRowSet.updateString("suburb", "hogwarts");
		myCachedRowSet.updateString("postcode", "23754");
		myCachedRowSet.updateString("home_phone",
				Integer.toString(myRandom.nextInt() & 0x7FFFFFFF));
		myCachedRowSet.updateString("mobile_phone",
				Integer.toString(myRandom.nextInt() & 0x7FFFFFFF));
		try {
			myCachedRowSet.insertRow();
		} catch (SQLException e) {
			System.out.println("Duplicate key or something. Row not inserted.");
		}
		// Move the cursor back to the current row
		myCachedRowSet.moveToCurrentRow();
		myCachedRowSet.acceptChanges(Database.getDatabaseConnection());

		System.out.println("");
		System.out.println("After Insert: ");
		printList();

		String tempAddress = "";
		// Update a record
		myCachedRowSet.beforeFirst();
		while (myCachedRowSet.next()) {
			if (myCachedRowSet.getString("name").equals("newest derp on the block")) {
				tempAddress = myCachedRowSet.getString("address");
			}
		}
		myCachedRowSet.beforeFirst();
		while (myCachedRowSet.next()) {
			if (myCachedRowSet.getString("name").equals("Lauren Jones")) {
				myCachedRowSet.updateString("name", "Lauren Derp on the block");
				myCachedRowSet.updateString("address", tempAddress);
				myCachedRowSet.updateString("suburb", "hogwarts");
				myCachedRowSet.updateString("postcode", "23754");
				try {
					myCachedRowSet.updateRow();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		// Move the cursor back to the current row
		myCachedRowSet.moveToCurrentRow();
		myCachedRowSet.acceptChanges(Database.getDatabaseConnection());

		System.out.println("");
		System.out.println("After Update: ");
		// Display our current member data
		printList();
		
		myCachedRowSet.beforeFirst();
		while (myCachedRowSet.next()) {
			if (myCachedRowSet.getString("name").equals("newest derp on the block")) {
				try { 
					myCachedRowSet.deleteRow();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		myCachedRowSet.moveToCurrentRow();
		myCachedRowSet.acceptChanges(Database.getDatabaseConnection());
		
		System.out.println("");
		System.out.println("After Delete: ");
		// Display our current member data
		printList();

		System.out.println("The End!");

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

	private void printList() throws SQLException {
		myCachedRowSet.beforeFirst();
		while (myCachedRowSet.next()) {
			System.out.println("Row number [" + myCachedRowSet.getRow()
					+ "], id [" + myCachedRowSet.getInt("id") + "], name ["
					+ myCachedRowSet.getString("name") + "], address ["
					+ myCachedRowSet.getString("address") + "], Suburb ["
					+ myCachedRowSet.getString("Suburb") + "], postcode ["
					+ myCachedRowSet.getString("postcode") + "], home phone ["
					+ myCachedRowSet.getString("home_phone") + "]");
		}
	}
}