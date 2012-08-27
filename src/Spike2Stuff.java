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
		// TODO Auto-generated method stub
		Database.getDatabaseConnection()
				.prepareStatement("INSERT INTO member (id, name, address, phone_number) VALUES (?,?,?,?) ON DUPLICATE KEY UPDATE company_code=?, date=?, open=?, high=?, low=?, close=?, volume=?, adjusted_close=?");

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

}
