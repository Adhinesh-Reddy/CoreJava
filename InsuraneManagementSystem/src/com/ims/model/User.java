package com.ims.model;

public class User {

	private int uid;
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	private String userName;
	private String password;
	private int user;
	public User(int id, String firstName, String lastName, String email, String mobile, int user, String userName, String password) {
		super();
		this.uid = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.userName = userName;
		this.password = password;
		this.user = user;
	}
	public User() {
		super();
	}
	public int getId() {
		return uid;
	}
	public void setId(int id) {
		this.uid = id;
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
	public String getMobile(String mobile){
		return mobile;
	}
	public void setMobile(String mobile){
		this.mobile = mobile;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
	public int getUser(){
		return user;
	}
	public void setUser(int user){
		this.user = user;
	}
}
