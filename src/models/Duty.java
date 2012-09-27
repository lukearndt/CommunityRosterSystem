package models;

import net.java.ao.Entity;
import net.java.ao.OneToMany;

/**
 * @author Luke Arndt & Deborah Harrington
 *
 */
public interface Duty extends Entity {
	
	public String getName();
	public void setName(String name);
	
	public String getDescription();
	public void setDescription(String description);
	
	@OneToMany
	public Capability[] getCapabilities();
}
