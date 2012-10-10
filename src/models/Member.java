package models;

import net.java.ao.Entity;
import net.java.ao.OneToMany;

/**
 * @author Luke Arndt & Deborah Harrington
 * 
 */
public interface Member extends Entity {

	public String getName();
	public void setName(String name);
	
	public String getAddress();
	public void setAddress(String address);
	
	public String getSuburb();
	public void setSuburb(String suburb);
	
	public String getState();
	public void setState(String state);
	
	public String getPostCode();
	public void setPostCode(String postCode);
	
	public int getSpouse_ID();
	public void setSpouse_ID(int spouse_ID);
	
	public String getHome_Phone();
	public void setHome_Phone(String home_Phone);
	
	public String getMobile_Phone();
	public void setMobile_Phone(String mobile_Phone);
	
	public double getBalance();
	public void setBalance(double balance);
	
	@OneToMany
	public Capability[] getCapabilities();
	
	@OneToMany
	public Book_Purchase[] getBook_Purchases();
}