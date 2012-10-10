package controllers;

import java.sql.SQLException;
import java.util.HashMap;

import models.Book;
import models.Book_Purchase;
import models.Capability;
import models.Duty;
import models.Member;
import net.java.ao.EntityManager;
import net.java.ao.Transaction;

import views.Console_Spike7;

/**
 * @author Luke Arndt & Deborah Harrington
 * @date 20 September 2012
 * 
 */
public class RosterSystem {
	static EntityManager manager;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		manager = new EntityManager(DbDetails.DATABASE_URL,
				DbDetails.USER_NAME, DbDetails.PASSWORD);
		// Start up the console
		Console_Spike7 myConsole = new Console_Spike7();
	}

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
				duty[i].setName(dutyInformation.get("Name").toString());
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
		// Duty duty = findDutyByName(dutyToDelete);
		// duty.delete();

		Duty[] duty;
		try {
			duty = manager.find(Duty.class, "name = ?", dutyToDelete);
			for (int i = 0; i < duty.length; i++) {
				manager.delete(duty[i]);
			}
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
			HashMap<String, Object> capabilityInformation) {
		Capability capability = null;
		Member[] member = null;
		Duty[] duty = null;
		try {
			capability = manager.create(Capability.class);
			member = manager.find(Member.class, "name = ?",
					capabilityInformation.get("memberName"));
			duty = manager.find(Duty.class, "name = ?",
					capabilityInformation.get("dutyName"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		Duty[] duty = null;
		Capability[] capability = null;
		try {
			duty = manager.find(Duty.class, "name = ?", dutyName);
			capability = manager.find(Capability.class, "Duty_ID = ?",
					duty[0].getID());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return capability;
	}

	public static double updateBook(int bookID, int boughtQuantity)
			throws SQLException{
		double bookPrice = 0;
		Book[] book = null;
		book = manager.find(Book.class, "ID = ?", bookID);
		book[0].setQuantity_On_Hand(book[0].getQuantity_On_Hand()
				- boughtQuantity);
		if (book[0].getQuantity_On_Hand() < 0) {
			throw new SQLException();
		}
		bookPrice = book[0].getPrice();
		book[0].save();
		return bookPrice;
	}

	public static void updateMemberBalance(int memberID, double purchasesCost, int purchaseQty)
			throws SQLException{
		Member[] member = null;
		member = manager.find(Member.class, "ID = ?", memberID);
		member[0].setBalance(member[0].getBalance() - (purchasesCost * purchaseQty));
		if (member[0].getBalance() < 0) {
			throw new SQLException();
		}
		member[0].save();
	}

	public static void addBookPurchase(int bookID, int memberID, int quantity) throws SQLException{
		Book_Purchase purchase = manager.create(Book_Purchase.class);
		purchase.setBook_ID(bookID);
		purchase.setMember_ID(memberID);
		purchase.setQuantity_Purchased(quantity);
		purchase.save();
	}

	public static String processMemberPurchases(final int memberID, final int bookID, final int purchaseQty) {
		String result = "";
		try {
			new Transaction<Object>(manager) {
				public Object run() throws SQLException {
					Double bookPrice = updateBook(bookID, purchaseQty);
					updateMemberBalance(memberID, bookPrice, purchaseQty);
					addBookPurchase(bookID, memberID, purchaseQty);
					return null;
				}
			}.execute();
			result = "transaction was successfully completed";
		} catch (SQLException e) {
			result = "transaction was unable to be completed";
		}
		return result;
	}
}