package com.pms.dao;

public interface UserDAO {	
	void login();
	void register();
	void forGotPassword();
	int verifyUserNameAndPassword(String uname,String pass);
	String forGotPassword(String uname);
}
