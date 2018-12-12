package fr.epita.bank.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.service.CustomerFileDAO;

public class TestCustomerToFile {

	public static void main(String[] args) throws FileNotFoundException {
		
		//testWriteCustomers();
		
		//testRead();
		
		CustomerFileDAO dao;
		try {
			dao = new CustomerFileDAO("customer.db");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
		dao.create(new Customer("Clément", "Saint-Denis"));
		dao.create(new Customer("François", "Créteil"));
		dao.create(new Customer("Armelle", "Louvres"));
		
		List<Customer> searchResults = dao.search(new Customer("Clé", "Saint-Denis"));
		
		System.out.println(searchResults);
		
		
	}

	private static void testRead() throws FileNotFoundException {
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
