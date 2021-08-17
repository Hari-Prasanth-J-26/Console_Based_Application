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
		
		CustomerAuthenticationService customerAuthenticationService = new CustomerAuthenticationServiceImpl();
		CustomerAuthenticationDAO customerAuthenticationDAO = new CustomerAuthenticationDAOImpl();

		Scanner sc = new Scanner(System.in);
		log.info("Welcome to Hari's Online Shopping APP");
		log.info("--------------------------------------");

		int ch = 0;
		
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
//				 log.info("Enter Customer Id");
//				 try {
//				 int id = Integer.parseInt(sc.nextLine());
//				 String customerSignIn = customerAuthenticationService.signIn(id);
//				 if (customerSignIn != "SignIn Successfull") {
//				 log.info("SignIn Unsuccessfull... Kindly Register first...");
//				 } else {
//				 log.info("SignIn Successfull");
//				 }
//				 } catch (NumberFormatException e) {
//				 log.warn("Player id should be digit only...");
//				 } catch (BusinessException e) {
//				 log.warn(e.getMessage());
//				 }
//				 break;

				
				log.info("Customer Authentication");
				Customer checkCustomer = new Customer();
				log.info("Enter User Eamil");
				checkCustomer.setEmail(sc.nextLine());
				String userEmail = checkCustomer.getEmail();
				log.info("Enter User Password");
				checkCustomer.setPassword(sc.nextLine());
				String userPassword = checkCustomer.getPassword();
					
				try {
					String customerSignIn = customerAuthenticationService.signIn(userEmail, userPassword);
					if (customerSignIn == "SignIn Successfull") {
						log.info("SignIn Successfully done...");
					} else {
						log.info("SignIn Unsuccessfull... Kindly Register first......");
					}
				} catch(BusinessException e) {
					log.error(e);
				}
				break;

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
				break;

			case 3:
				log.info("Register by using your First name, Last name, Email and Password");
				Customer customer = new Customer();
				log.info("Enter Customer First Name");
				customer.setFirstName(sc.nextLine());
				String firstName = customer.getFirstName();
				log.info("Enter Customer Last Name");
				customer.setLastName(sc.nextLine());
				String lastName = customer.getLastName();
				log.info("Enter Customer Email");
				customer.setEmail(sc.nextLine());
				String email = customer.getEmail();
				log.info("Enter Customer Password");
				customer.setPassword(sc.nextLine());
				String password = customer.getPassword();
				
				Customer customerDetails = new Customer(firstName, lastName, email, password);
				try {
					customerDetails = customerAuthenticationDAO.signUp(customerDetails);
					if(customerDetails.getId()!=0) {
						log.info(customerDetails);
						log.info("SignUp Successfully done...Now you can SignIn");
					}
				}catch(BusinessException e) {
					log.error(e);
				}				

				break;
			}

		} while (ch != 4);

	}

}
