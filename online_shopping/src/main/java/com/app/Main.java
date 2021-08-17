package com.app;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.authentication.dao.CustomerAuthenticationDAO;
import com.app.authentication.dao.impl.CustomerAuthenticationDAOImpl;
import com.app.authentication.service.CustomerAuthenticationService;
import com.app.authentication.service.impl.CustomerAuthenticationServiceImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;

public class Main {

	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) throws BusinessException {

		Scanner sc = new Scanner(System.in);
		log.info("Welcome to Hari's Online Shopping APP");
		log.info("--------------------------------------");

		int ch = 0;
		CustomerAuthenticationService customerAuthenticationService = new CustomerAuthenticationServiceImpl();
		CustomerAuthenticationDAO customerAuthenticationDAO = new CustomerAuthenticationDAOImpl();
		do {
			log.info("\nMAIN MENU");
			log.info("1)Login as Customer");
			log.info("2)Login as Employee");
			log.info("3)Register as Customer");
			log.info("4)EXIT");
			log.info("Please enter your choice 1-4 only");
			try {
				ch = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				log.error(e);
			}

			switch (ch) {
			case 1:
				// log.info("Enter Customer Id");
				// try {
				// int id = Integer.parseInt(sc.nextLine());
				// String customerSignIn = customerAuthenticationService.signIn(id);
				// if (customerSignIn != "SignIn Successfull") {
				// log.info("SignIn Unsuccessfull... Kindly Register first...");
				// } else {
				// log.info("SignIn Successfull");
				// }
				// } catch (NumberFormatException e) {
				// log.warn("Player id should be digit only...");
				// } catch (BusinessException e) {
				// log.warn(e.getMessage());
				// }
				// break;

				log.info("Enter Username");
				String username = sc.nextLine();
				log.info("Enter password");
				String password = sc.nextLine();
				String customerSignIn = customerAuthenticationService.signIn(username, password);
				if (customerSignIn != "SignIn Successfull") {
					log.info("SignIn Unsuccessfull... Kindly Register first......");
				} else {
					log.info("SignIn Successfull");
				}

			case 2:
//				log.info("Enter Employee id");
//				try {
//					int id = Integer.parseInt(sc.nextLine());
//					String customerSignIn = customerAuthenticationService.signIn(id);
//					if (customerSignIn != "SignIn Successfull") {
//						log.info("SignIn Unsuccessfull... Kindly Register first...");
//					} else {
//						log.info("SignIn Successfull");
//					}
//				} catch (NumberFormatException e) {
//					log.warn("Player id should be digit only...");
//				} catch (BusinessException e) {
//					log.warn(e.getMessage());
//				}
//				break;

			case 3:
				log.info("Register by using First name, Last name, Email and Password");
				Customer customer = new Customer();
				// log.info("Your Customer Id : ");
				log.info("Enter Customer Id");
				customer.setId(Integer.parseInt(sc.nextLine()));
				log.info("Enter Customer First Name");
				customer.setFirstName(sc.nextLine());
				log.info("Enter Customer Last Name");
				customer.setLastName(sc.nextLine());
				log.info("Enter Customer email");
				customer.setEmail(sc.nextLine());
				log.info("Enter Customer password");
				customer.setPassword(sc.nextLine());

				String customerSignUp = customerAuthenticationService.signUp(customer);
				if (customerSignUp != "SignUp Successfull") {
					log.info("SignUp Unsuccessfull... Please Register again.........");
				} else {
					log.info(customer);
					log.info("SignUp Successfull");
				}

				break;
			}

		} while (ch != 4);

	}

}
