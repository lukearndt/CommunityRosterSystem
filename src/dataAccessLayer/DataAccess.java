package dataAccessLayer;

/**
 * @author Luke Arndt & Deborah Harrington
 * 
 */
public interface DataAccess {

	// Getters for Member

	public Member getMemberById(int memberId);

	public Member getMemberByName(String memberName);

	public Member getMemberBySpouse(int spouseId);

	// Setters for Member

	public void saveMember(Member member);

	public void addMember(Member member);
	
}
