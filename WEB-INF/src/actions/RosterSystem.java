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

	protected static EntityManager manager = new EntityManager(
			DbDetails.getDatabaseUrl(), DbDetails.getUserName(),
			DbDetails.getPassword());;

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
			e.printStackTrace();
		}
	}

	public static void updateMember(String name,
			HashMap<String, Object> memberInformation) {
		Member[] member;
		try {
			member = manager.find(Member.class, "name = ?", name);
			for (int i = 0; i < member.length; i++) {
				member[i].setName(memberInformation.get("name").toString());
				member[i].setAddress(memberInformation.get("address")
						.toString());
				member[i].setSuburb(memberInformation.get("suburb").toString());
				member[i].setState(memberInformation.get("state").toString());
				member[i].setPostCode(memberInformation.get("postCode")
						.toString());
				member[i].setHome_Phone(memberInformation.get("home_Phone")
						.toString());
				member[i].setMobile_Phone(memberInformation.get("mobile_Phone")
						.toString());
				member[i].save();
				System.out.println("the update should have worked, I think.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("The update failed :(");
			e.printStackTrace();
		}
	}

	public static void deleteMember(String memberToDelete) {
		Member[] member;
		try {
			member = manager.find(Member.class, "name = ?", memberToDelete);
			for (int i = 0; i < member.length; i++) {
				manager.delete(member[i]);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Member[] getMemberList() {
		Member[] memberList = null;
		try {
			memberList = manager.find(Member.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberList;
	}

	public static void addDuty(HashMap<String, Object> dutyInformation) {
		Duty newDuty;
		try {
			newDuty = manager.create(Duty.class, dutyInformation);
			newDuty.save();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void updateDuty(String name,
			HashMap<String, Object> dutyInformation) {
		Duty[] duty = null;
		try {
			duty = manager.find(Duty.class, "name = ?", name);
			for (int i = 0; i < duty.length; i++) {
				duty[i].setName(dutyInformation.get("name").toString());
				duty[i].setDescription(dutyInformation.get("description")
						.toString());
				duty[i].save();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deleteDuty(String dutyToDelete) {
		Duty duty;
		try {
			duty = findDuty(dutyToDelete);
			manager.delete(duty);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Duty[] getDutyList() {
		Duty[] dutyList = null;
		try {
			dutyList = manager.find(Duty.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dutyList;
	}

	public static void addCapability(
			HashMap<String, Object> capabilityInformation) throws SQLException {
		Capability capability = null;
		Member[] member = null;
		Duty[] duty = null;
		capability = manager.create(Capability.class);
		member = manager.find(Member.class, "name = ?",
				capabilityInformation.get("memberName"));
		duty = manager.find(Duty.class, "name = ?",
				capabilityInformation.get("dutyName"));
		capability.setDuty_ID(duty[0].getID());
		capability.setMember_ID(member[0].getID());
		capability.save();
	}

	public static Capability[] findMemberCapabilities(String memberName) {
		Member[] member = null;
		Capability[] capability = null;
		try {
			member = manager.find(Member.class, "name = ?", memberName);
			capability = manager.find(Capability.class, "Member_ID = ?",
					member[0].getID());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return capability;
	}

	public static void deleteCapability(
			HashMap<String, Object> capabilityInformation) {
		Member[] member = null;
		Duty[] duty = null;
		Capability[] capability = null;
		try {
			member = manager.find(Member.class, "name = ?",
					capabilityInformation.get("memberName"));
			duty = manager.find(Duty.class, "name = ?",
					capabilityInformation.get("dutyName"));
			capability = manager.find(Capability.class,
					"Member_ID = ? and Duty_ID = ?", member[0].getID(),
					duty[0].getID());
			manager.delete(capability);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Capability[] findDutyCapabilities(String dutyName) {
		Duty duty = null;
		Capability[] capability = null;
		try {
			duty = findDuty(dutyName);
			capability = manager.find(Capability.class, "Duty_ID = ?",
					duty.getID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return capability;
	}

	public static Duty findDuty(String dutyName) {
		Duty[] duty = null;
		try {
			duty = manager.find(Duty.class, "name = ?", dutyName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return duty[0];
	}

	public static Duty findDutyByID(int dutyID) {
		Duty[] duty = null;
		try {
			duty = manager.find(Duty.class, "ID = ?", dutyID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return duty[0];
	}

	public static Member findMemberByID(int member_ID) {
		Member[] member = null;
		try {
			member = manager.find(Member.class, "ID = ?", member_ID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member[0];
	}

	public static boolean checkLogin(String email, String password) {
		Member [] member = null;
		try {
			member = manager.find(Member.class, "email = ?", email);
			if (member[0].getPassword().compareTo(password)==0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
}