package sait.sll.problemdomain;

import java.io.*;

/**
 * Represents a user.
 * @author Maria Laura Diaz Pena, Justin Van Groningen
 * @version July 24, 2020
 *
 */
public class User implements Serializable{
	
	/**
	 * User ID
	 */
	private int id;
	
	/**
	 * User Name
	 */
	private String name;
	
	/**
	 * User email.
	 */
	private String email;
	
	/**
	 * User password.
	 */
	private String password;
	
	/**
	 * Initializes a User object.
	 * @param id ID
	 * @param name Name
	 * @param email E-mail address
	 * @param password Password
	 */
	public User(int id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	/**
	 * Gets the users ID.
	 * @return Users ID
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Gets the users name.
	 * @return Name.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gets the users email.
	 * @return E-mail address.
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Gets the users password
	 * @return Password
	 */
	public String getPassword() {
		return this.password;
		
	}
	
	/**
	 * Sets the user ID
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Sets the user's Name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Sets user's email
	 * @param email 
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Sets user's password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Checks if the passed password is correct.
	 * @param password Password to check.
	 * @return True if password is correct.
	 */
	public boolean isCorrectPassword(String password) {
		if (this.password == null && password == null)
			return true;
		else if (this.password == null || password == null)
			return false;
		else
			return this.password.equals(password);
	}
	
	/**
	 * Checks if object is equal to another object.
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof User))
			return false;
		
		User other = (User) obj;
		
		return this.id == other.id && this.name.equals(other.name) && this.email.equals(other.email);
	}
}
