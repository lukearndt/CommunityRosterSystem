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

	public void insert() {
		try {
			Database.getDatabaseConnection()
					.prepareStatement("INSERT INTO member (id, name, address, phone_number) VALUES (?,?,?,?) ON DUPLICATE KEY UPDATE company_code=?, date=?, open=?, high=?, low=?, close=?, volume=?, adjusted_close=?");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void update() {
		// TODO Auto-generated method stub

	}

	public void delete() {
		// TODO Auto-generated method stub

	}

	public void select() {
		// TODO Auto-generated method stub

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
