package com.reimbursement.models;

public class User {

	private Long userID;
	private String userName;
	private String userPassword;
	private String firstName;
	private String lastName;
	private String email;
	private Long roleID;

	public User() {
		super();
	}

	public User(Long userID, String userName, String userPassword, String firstName, String lastName, String email,
			Long roleID) {
		this.userID = userID;
		this.userName = userName;
		this.userPassword = userPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roleID = roleID;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getRoleID() {
		return roleID;
	}

	public void setRoleID(Long roleId) {
		this.roleID = roleId;
	}

	@Override
	public String toString() {
		return "Users{" + "userID=" + userID + ", userName='" + userName + '\'' + ", userPassword='" + userPassword
				+ '\'' + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", email='" + email
				+ '\'' + ", roleID=" + roleID + '}';
	}

}