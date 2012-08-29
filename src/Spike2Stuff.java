import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 * 
 * @author Luke Arndt & Deborah Harrington
 * @date 27 August 2012
 * 
 *       A class that shouldn't exist in the long term. This is basically just a
 *       wrapper for all of the stuff that we need to get done for Spike 2.
 * 
 */
public class Spike2Stuff {

	public void insert(String name, String address, String suburb, String state, String postCode, String homePhone, String mobilePhone) {
		try {
			PreparedStatement preparedStatement = Database.getDatabaseConnection()
					.prepareStatement("INSERT INTO member (name, address, suburb, state, postcode, homephone, mobilephone) VALUES (?,?,?,?,?,?,?)");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, address);
			preparedStatement.setString(3, suburb);
			preparedStatement.setString(4, state);
			preparedStatement.setString(5, postCode);
			preparedStatement.setString(6, homePhone);
			preparedStatement.setString(7, mobilePhone);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void update(String name, String address, String suburb, String state, String postCode) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = Database.getDatabaseConnection()
					.prepareStatement("UPDATE Member SET address = ?, suburb = ?, state = ?, postcode = ? WHERE name = ?");
			preparedStatement.setString(1, address);
			preparedStatement.setString(2, suburb);
			preparedStatement.setString(3, state);
			preparedStatement.setString(4, postCode);
			preparedStatement.setString(5, name);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void delete(String name) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = Database.getDatabaseConnection()
									.prepareStatement("DELETE FROM Member where name = ?");
			preparedStatement.setString(1, name);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Member> select(String aName) {
		ArrayList<Member> memberList = new ArrayList<Member>();
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		String query = "Select * from member where name = ?";
		try {
			preparedStatement = Database.getDatabaseConnection().prepareStatement(query);
			preparedStatement.setString(1, aName);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int ID = resultSet.getInt(1); 
				String name = resultSet.getString(2);
				String address = resultSet.getString(3);  
				String suburb = resultSet.getString(4);
				String state = resultSet.getString(5); 
				String postCode = resultSet.getString(6);
				int spouseID = resultSet.getInt(7);
				String homePhone = resultSet.getString(8); 
				String mobilePhone = resultSet.getString(9);
				Member newMember = new Member(ID, name, address, suburb, state, postCode, spouseID, homePhone, mobilePhone);
				memberList.add(newMember);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return memberList;
	}

	public ArrayList<Member> list() {
		ArrayList<Member> memberList = new ArrayList<Member>();
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		String query = "Select * from member";
		try {
			preparedStatement = Database.getDatabaseConnection().prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int ID = resultSet.getInt(1); 
				String name = resultSet.getString(2);
				String address = resultSet.getString(3);  
				String suburb = resultSet.getString(4);
				String state = resultSet.getString(5); 
				String postCode = resultSet.getString(6);
				int spouseID = resultSet.getInt(7);
				String homePhone = resultSet.getString(8); 
				String mobilePhone = resultSet.getString(9);
				Member newMember = new Member(ID, name, address, suburb, state, postCode, spouseID, homePhone, mobilePhone);
				memberList.add(newMember);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return memberList;
	}
}
