package controller;

import java.sql.SQLException;

import org.javalite.activejdbc.Base;

import dataAccessLayer.Database;
import dataAccessLayer.Spike3Stuff;

/**
 * @author Luke Arndt & Deborah Harrington
 * @date 23 August 2012
 * 
 */
public class RosterSystem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Initialize our data access layer
		Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3307/duty_roster", "SystemUser", "lk7^t5$FbN3$");

		Base.close();
	}
}