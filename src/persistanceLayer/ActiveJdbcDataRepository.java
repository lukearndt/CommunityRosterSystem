/**
 * 
 */
package persistanceLayer;

import java.util.List;

import org.javalite.activejdbc.Base;

/**
 * @author Luke Arndt & Deborah Harrington
 * 
 */
public class ActiveJdbcDataRepository implements IDataRepository {

	private static final String PASSWORD = "lk7^t5$FbN3$";
	private static final String USER_NAME = "SystemUser";
	private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3307/duty_roster";

	protected ActiveJdbcDataRepository() {
		
	}

	// Procedure for closing connection
	private void close() {
		Base.close();
	}

	// Procedure for opening connection
	private void open() {
		Base.open(DATABASE_DRIVER, DATABASE_URL, USER_NAME, PASSWORD);
	}

	// IDataRepository interface methods

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

	
	@Override
	public Member getMemberById(int memberId) {
		return Member.findById(memberId);
	}

	@Override
	public List<Member> getMembersByName(String memberName) {
		return Member.where("name = ?", memberName);
	}

	@Override
	public Member getMemberBySpouse(int spouseId) {
		return Member.findFirst("spouse_id = ?", spouseId);
	}
	
	// Not yet implemented methods are below this line

	@Override
	public void saveMember(Member member) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addMember(Member member) {
		// TODO Auto-generated method stub

	}

}
