package actions;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.SQLException;
import java.util.HashMap;
import models.Capability;
import models.DbDetails;
import models.Duty;
import models.Member;
import net.java.ao.EntityManager;


/**
 * @author Luke Arndt & Deborah Harrington
 * @date 20 September 2012
 * 
 */
public class RosterSystem extends ActionSupport {

	private static final long serialVersionUID = 4944803812385887371L;
	
	protected static EntityManager manager = new EntityManager(DbDetails.getDatabaseUrl(),
			DbDetails.getUserName(), DbDetails.getPassword());;

	/**
	 * 
	 * @param memberInformation
	 */
	public static void addMember(HashMap<String, Object> memberInformation) {
		Member newMember;
		try {
			newMember = manager.create(Member.class, memberInformation);
			newMember.save();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void updateMember(String name,
			HashMap<String, Object> memberInformation) {
		Member[] member;
		try {
			member = manager.find(Member.class, "name = ?", name);
			for (int i = 0; i < member.length; i++) {
				member[i].setName(memberInformation.get("Name").toString());
				member[i].setAddress(memberInformation.get("address")
						.toString());
				member[i].setSuburb(memberInformation.get("suburb").toString());
				member[i].setState(memberInformation.get("state").toString());
				member[i].setPostCode(memberInformation.get("postcode")
						.toString());
				member[i].setHome_Phone(memberInformation.get("home_Phone")
						.toString());
				member[i].setMobile_Phone(memberInformation.get("mobile_Phone")
						.toString());
				member[i].save();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deleteMember(String memberToDelete) {
		Member[] member;
		try {