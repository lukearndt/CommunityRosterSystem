package dataAccessLayer;

import java.util.List;

/**
 * @author Luke Arndt & Deborah Harrington
 * 
 */
public interface IDataAccess {

	// Transactions

	public void startTransaction();

	public void commitTransaction();

	public void rollbackTransaction();

	// Getters for Member

	public Member getMemberById(int memberId);

	public List<Member> getMembersByName(String memberName);

	public Member getMemberBySpouse(int spouseId);

	// Setters for Member

	public void saveMember(Member member);

	public void addMember(Member member);

}
