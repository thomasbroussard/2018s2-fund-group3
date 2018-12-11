package fr.epita.bank.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.epita.bank.datamodel.Customer;

public class TestCustomerToFile {

	public static void main(String[] args) throws FileNotFoundException {
		
		//testWriteCustomers();
		
		File file = new File("customer.db");
		Scanner scanner = new Scanner(file);
   
		List<Customer> customers = new ArrayList<Customer>(); 
		while(scanner.hasNext()) {
			scanner.nextLine();
			String name = scanner.nextLine();
			String address = scanner.nextLine();
			Customer customer = new Customer(name, address);
			customers.add(customer);
			scanner.nextLine();
		}
		
		System.out.println(customers);
		
		
		
		
		
	}

	private static void testWriteCustomers() throws FileNotFoundException {
		Customer customer = new Customer("Thomas", "Paris");
		Customer customer2 = new Customer("Quentin", "Paris");
		Customer customer3 = new Customer("Sandy", "Yerres");
		
		File file = new File("customer.db");
		PrintWriter writer = new PrintWriter(new FileOutputStream(file, true));
		writeCustomer(customer, writer);
		writeCustomer(customer2, writer);
		writeCustomer(customer3, writer);
		
	
		writer.flush();
		writer.close();
	}

	private static void writeCustomer(Customer customer, PrintWriter writer) {
		writer.println("-------");
		writer.println(customer.getName());
		writer.println(customer.getAddress());
		writer.println("-------");
	}
	
}
