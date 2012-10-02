package rostersystem.models;

import net.java.ao.Entity;

/**
 * @author Luke Arndt & Deborah Harrington
 *
 */
public interface Capability extends Entity {
	
	public int getMember_ID();
	public void setMember_ID(int member_ID);
	
	public int getDuty_ID();
	public void setDuty_ID(int duty_ID);
}