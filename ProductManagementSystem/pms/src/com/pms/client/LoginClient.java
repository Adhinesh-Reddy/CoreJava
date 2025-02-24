package com.pms.client;

import java.util.Scanner;

import com.pms.dao.impl.UserDAOImpl;

public class LoginClient {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserDAOImpl daoImpl = new UserDAOImpl();
		while (true) {
			System.out.println("============================================");

			System.out.println("               1)Login              ");
			System.out.println("               2)Register                     ");
			System.out.println("               3)ForgotPassword              ");
			System.out.println("               4)Exit              ");

			System.out.println("============================================");

			System.out.println("Enter the choice");
			int choice = sc.nextInt();
			switch (choice) {

			case 1:
				daoImpl.login();
				break;
			case 2:
				daoImpl.register();
				break;
			case 3:
				daoImpl.forGotPassword();
				break;
			case 4:
				System.out.println("Thx for using App!");
				System.exit(0);

			default:
				System.out.println("Choose 1 to 4 between");

			}// end choice

		} // end of while

	}

}
