package fr.epita.bank.launcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.epita.bank.datamodel.Account;
import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.InvestmentAccount;
import fr.epita.bank.datamodel.SavingsAccount;

public class Launcher {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Customer customer = handleCustomerInitialization(scanner);

		handleAccountsInitialization(scanner, customer);

		System.out.println("you created this customer (with details on account) : ");
		System.out.println(customer);

		scanner.close();

	}

	private static void handleAccountsInitialization(Scanner scanner, Customer customer) {
		String answer;
		System.out.println("Account initialization");
		System.out.println("-----------------------");
		
		
		boolean continueAddition = true;
		while(continueAddition) {
		
			System.out.println("Please enter an account type");
			System.out.println("1. savings");
			System.out.println("2. investments");
			System.out.print("your answer (1/2): ");
			answer = scanner.nextLine();
			
			List<Account> accountsList = customer.getAccountsList();
			if (accountsList == null) {
				accountsList = new ArrayList<Account>();
				customer.setAccountsList(accountsList);
			}
			Account account = null;
			if (answer.equals("1")){
				System.out.println("you've selected Savings Account creation, please input an initial balance : ");
				double initialBalance = scanner.nextDouble();
				System.out.println("input an interrest rate : ");
				double interrestRate = scanner.nextDouble();
				account = new SavingsAccount(initialBalance, interrestRate);
				
			} else if (answer.equals("2")) {
				account = new InvestmentAccount(250.0);
			} else {
				//TODO
				System.out.println("You did not enter a valid answer!");
			}
			if (account != null) {
				accountsList.add(account);
			}
			System.out.println("do you want to continue adding accounts for that customer ? (Y/N)");
			answer = scanner.nextLine();
			continueAddition = "Y".equals(answer); //answer.equals("Y");
			
		}
	}

	private static Customer handleCustomerInitialization(Scanner scanner) {
		System.out.println("Customer initialization");
		System.out.println("-----------------------");
		System.out.println("Please enter an address");
		String address = scanner.nextLine();
		System.out.println("Please enter a name for the customer");
		String name = scanner.nextLine();

		Customer customer = new Customer(name, address);

		System.out.print("You are about to create the following customer: ");

		System.out.println(customer);

		System.out.print("do you confirm? (Y/N) : ");
		return customer;
	}

}
