package com.app;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.authentication.dao.CustomerAuthenticationDAO;
import com.app.authentication.dao.impl.CustomerAuthenticationDAOImpl;
import com.app.authentication.service.CustomerAuthenticationService;
import com.app.authentication.service.impl.CustomerAuthenticationServiceImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.Employee;

public class Main {

	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) throws BusinessException {
		
		CustomerAuthenticationService customerAuthenticationService = new CustomerAuthenticationServiceImpl();
		CustomerAuthenticationDAO customerAuthenticationDAO = new CustomerAuthenticationDAOImpl();

		Scanner sc = new Scanner(System.in);
		log.info("Welcome to Hari's Online Shopping APP");
		log.info("--------------------------------------");

		int choice = 0;
		
		do {
			log.info("\nMAIN MENU");
			log.info("1)Login as Customer");
			log.info("2)Login as Employee");
			log.info("3)Register as Customer");
			log.info("4)EXIT");
			log.info("Please enter your choice 1-4 only");
			try {
				choice = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				log.error(e);
			}

			switch (choice) {
			case 1:
				log.info("Customer Authentication");
				Customer checkCustomer = new Customer();
				log.info("\nEnter User Eamil");
				checkCustomer.setEmail(sc.nextLine());
				String userEmail = checkCustomer.getEmail();
				log.info("Enter User Password");
				checkCustomer.setPassword(sc.nextLine());
				String userPassword = checkCustomer.getPassword();
					
				try {
					String customerSignIn = customerAuthenticationService.signIn(userEmail, userPassword);
					if (customerSignIn == "SignIn Successfull") {
						log.info("SignIn Successfully done...");
						log.info("Hari's Online Shopping APP, Heartly Welcomes you :)");
						log.info("----------------------------------------------------");
						int option = 0;
						do {
							log.info("\nNew and Exciting products are available");
							log.info("1)Search Products");
							log.info("2)View Orders");
							log.info("3)SignOut");
							log.info("Please enter your option 1-3 only");
							
							try {
								option = Integer.parseInt(sc.nextLine());
							} catch (NumberFormatException e) {
								log.error(e);
							}
							switch(option) {
							case 1:
								break;
							case 2:
								break;
							case 3:
								log.info("Thanks for using this APP... See you soon..");
								break;
							default :
								break;
							}
						}while(option!=3);
						
					} else {
						log.info("SignIn Unsuccessfull... Kindly Register first......");
					}
				} catch(BusinessException e) {
					log.error(e);
				}
				break;

			case 2:
				log.info("Employee Authentication");
				Employee checkEmployee = new Employee();
				log.info("\nEnter Employee Username");
				checkEmployee.setUsername(sc.nextLine());
				String employeeUsername = checkEmployee.getUsername();
				log.info("Enter Employee Password");
				checkEmployee.setPassword(sc.nextLine());
				String employeePassword = checkEmployee.getPassword();
				String employeeLogIn = checkEmployee.logIn(employeeUsername, employeePassword);
				if(employeeLogIn == "LogIn Successfull") {
					log.info("Employee LogIn Successfull...");
				}
				else {
					log.info("Employee Authentication failed..");
				}

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
			case 4 :
				log.info("Thank You...Have a nice day :-)");
				break;
			default :
				log.warn("Invalid Option.... Choice should be numbers and 1-4 only.. kindly retry");
				break;
			}

		} while (choice != 4);

	}

}
