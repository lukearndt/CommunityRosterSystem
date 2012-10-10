package models;

import net.java.ao.Entity;

public interface Book_Purchase extends Entity {
	public int getMember_ID();
	public void setMember_ID(int member_ID);
	
	public int getBook_ID();
	public void setBook_ID(int book_ID);
	
	public int getQuantity_Purchased();
	public void setQuantity_Purchased(int quantity_Purchased);
}
