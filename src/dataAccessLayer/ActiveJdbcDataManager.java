/**
 * 
 */
package dataAccessLayer;

import org.javalite.activejdbc.Base;

/**
 * @author Luke Arndt & Deborah Harrington
 * 
 */
public class ActiveJdbcDataManager implements DataAccess {

	private static final String PASSWORD = "lk7^t5$FbN3$";
	private static final String USER_NAME = "SystemUser";
	private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3307/duty_roster";

	protected ActiveJdbcDataManager() {
		Base.open(DATABASE_DRIVER, DATABASE_URL, USER_NAME, PASSWORD);
		
		// TODO : Figure out where to close this connection as Java doesn't let me make a destructor method
	}

	@Override
	public void startTransaction() {
		Base.openTransaction();
	}

	@Override
	public void commitTransaction() {
		Base.commitTransaction();
	}

	@Override
	public void rollbackTransaction() {
		Base.rollbackTransaction();
	}

	
	
	// Not yet implemented methods are below this line
	
	@Override
	public Member getMemberById(int memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member getMemberByName(String memberName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member getMemberBySpouse(int spouseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveMember(Member member) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addMember(Member member) {
		// TODO Auto-generated method stub

	}

}
