package controllers;

import java.util.HashMap;
import java.util.Map;

import models.Capabilities;
import models.Duty;
import models.Member;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;

import views.Console;

/**
 * @author Luke Arndt & Deborah Harrington
 * @date 20 September 2012
 * 
 */
public class RosterSystem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Base.open(DbDetails.DATABASE_DRIVER, DbDetails.DATABASE_URL,
				DbDetails.USER_NAME, DbDetails.PASSWORD);
		// Start up the console
		Console myConsole = new Console();
		Base.close();
	}

	/**
	 * 
	 * @param memberInformation
	 */
	public static void addMember(HashMap<String, Object> memberInformation) {
		Member newMember = new Member();
		for (Map.Entry<String, Object> entry : memberInformation.entrySet()) {
			// key = field name
			newMember.set(entry.getKey(), entry.getValue());
		}
		newMember.saveIt();
	}

	public static void updateMember(String name,
			HashMap<String, Object> memberInformation) {
		Member member = findMemberByName(name);
		for (Map.Entry<String, Object> entry : memberInformation.entrySet()) {
			member.set(entry.getKey(), entry.getValue());
		}
	}

	public static void deleteMember(String memberToDelete) {
		Member member = findMemberByName(memberToDelete);
		member.delete();
	}

	public static Member findMemberByName(String name) {
		Member member = Member.findFirst("name = ?", name);
		return member;
	}

	public static LazyList<Member> getMemberList() {
		return Member.findAll();
	}

	public static void addDuty(HashMap<String, Object> dutyInformation) {
		Duty newDuty = new Duty();
		for (Map.Entry<String, Object> entry : dutyInformation.entrySet()) {
			// key = field name
			newDuty.set(entry.getKey(), entry.getValue());
		}
		newDuty.saveIt();
	}

	public static void updateDuty(String name,
			HashMap<String, Object> dutyInformation) {
		Duty duty = findDutyByName(name);
		for (Map.Entry<String, Object> entry : dutyInformation.entrySet()) {
			duty.set(entry.getKey(), entry.getValue());
		}
	}

	public static void deleteDuty(String dutyToDelete) {
		Duty duty = findDutyByName(dutyToDelete);
		duty.delete();
	}

	public static Duty findDutyByName(String name) {
		Duty duty = Duty.findFirst("name = ?", name);
		;
		return duty;
	}

	public static LazyList<Duty> getDutyList() {
		return Duty.findAll();
	}

	public static void addCapability(
			HashMap<String, Object> capabilityInformation) {
		Member member = findMemberByName(capabilityInformation
				.get("memberName").toString());
		Duty duty = findDutyByName(capabilityInformation.get("dutyName")
				.toString());

		member.add(duty);
	}

	public static LazyList<Capabilities> findMemberCapabilities(String memberName) {
		Member member = findMemberByName(memberName);
		LazyList<Capabilities> capability = Capabilities.find("Member_ID", member.getId());
		return capability;
	}

	public static void deleteCapability(
			HashMap<String, Object> capabilityInformation) {
		Member member = findMemberByName(capabilityInformation
				.get("memberName").toString());
		Duty duty = findDutyByName(capabilityInformation.get("dutyName")
				.toString());

		member.remove(duty);
	}

	public static LazyList<Capabilities> findDutyCapabilities(String dutyName) {
		Duty duty = findDutyByName(dutyName);
		LazyList<Capabilities> capability = Capabilities.find("Duty_ID", duty.getId());
		return capability;
	}
}