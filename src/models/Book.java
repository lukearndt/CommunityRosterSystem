package models;

import net.java.ao.Entity;
import net.java.ao.OneToMany;

public interface Book extends Entity {
	
	public String getName();
	public void setName(String name);

	public int getQuantity_On_Hand();
	public void setQuantity_On_Hand(int quantity_On_Hand);
	
	public Double getPrice();
	public void setPrice(Double price);
	
	@OneToMany
	public Book_Purchase[] getBook_Purchases();
}
