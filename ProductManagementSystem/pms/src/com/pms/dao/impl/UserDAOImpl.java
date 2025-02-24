package com.pms.dao.impl;

import java.util.Scanner;

import com.pms.dao.UserDAO;
import com.pms.model.User;
import com.pms.details.UserDetails;

public class UserDAOImpl implements UserDAO {

	User[] addUsers = new User[2];

	Scanner sc = new Scanner(System.in);

	@Override
	public void register() {
		for (int i = 0; i < 2; ++i) {
			System.out.println("Enter User Id");
			int id = sc.nextInt();
			System.out.println("Enter First Name");
			String fname = sc.next();
			System.out.println("Enter Last Name");
			String lname = sc.next();
			System.out.println("Enter Email");
			String email = sc.next();
			System.out.println("Enter Mobile Number");
			String mobile = sc.next();
			System.out.println("Enter 1 for user or enter 2 for admin");
			int u = sc.nextInt();
			System.out.println("Enter User Name");
			String uname = sc.next();
			System.out.println("Enter Password");
			String pass = sc.next();
			User user = new User(id, fname, lname, email, mobile, u, uname, pass);
			addUsers[i] = user;

			System.out.println("Registration is SuccessFull");

		} // end of for
	}

	@Override
	public void login(){
		System.out.println("Enter User Name");
				String uname = sc.next();
				System.out.println("Enter Password ");
				String pass = sc.next();
				int flag = verifyUserNameAndPassword(uname, pass);
				if (flag == 1)
					UserDetails.userMenu();
				else if(flag == 2){
					UserDetails.adminMenu();
				}
				else
					System.out.println("In-Valid User");
	}

	@Override
	public void forGotPassword(){
		System.out.println("enter User Name");
				String name = sc.next();
				String password = forGotPassword(name);
				if (password != null)
					System.out.println("Your Password : " + password);
				else
					System.out.println("User Name is not Exist");
	}

	@Override
	public int verifyUserNameAndPassword(String uname, String pass) {		
		for(User u : addUsers)
		{
			if((u.getUserName().equals(uname)&&u.getPassword().equals(pass)) && u.getUser() == 1)
			{
				return 1;
			}else if((u.getUserName().equals(uname)&&u.getPassword().equals(pass)) && u.getUser() == 2)
			{
				return 2;
			}
		}
		return 0;
	}

	@Override
	public String forGotPassword(String uname) {
		for(User us : addUsers)
		{
			if(us.getUserName().equals(uname))
				return us.getPassword();
		}
		return null;
	}

}
