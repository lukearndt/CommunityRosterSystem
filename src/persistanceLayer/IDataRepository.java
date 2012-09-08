package persistanceLayer;

import java.util.List;

/**
 * @author Luke Arndt & Deborah Harrington
 * 
 */
public interface IDataRepository {

	// Transactions

	public void startTransaction();

	public void commitTransaction();

	public void rollbackTransaction();

	// Getters for ApplicationMember

	public Member getMemberById(int memberId);

	public List<Member> getMembersByName(String memberName);

	public Member getMemberBySpouse(int spouseId);

	// Setters for ApplicationMember

	public void saveMember(Member member);

	public void addMember(Member member);

}
