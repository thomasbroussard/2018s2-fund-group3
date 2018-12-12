package fr.epita.bank.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.epita.bank.datamodel.Customer;

public class CustomerFileDAO {

	private PrintWriter writer;
	private Scanner scanner;
	private File file;

	public CustomerFileDAO(String path) throws IOException {
		File file = new File(path);
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			file.createNewFile();
		}
		this.file = file;
		this.writer = new PrintWriter(new FileOutputStream(file, true));
		this.scanner = new Scanner(file);
	}

	public void create(Customer customer) {
		writer.println("-------");
		writer.println(customer.getName());
		writer.println(customer.getAddress());
		writer.println("-------");
		writer.flush();
	}

	public void update(Customer customer) {

	}

	public void delete(Customer customer) {

	}

	public List<Customer> search(Customer criteria) {
		List<Customer> customers = new ArrayList<Customer>();
		while (scanner.hasNext()) {
			scanner.nextLine();
			String name = scanner.nextLine();
			String address = scanner.nextLine();
			if (name.startsWith(criteria.getName()) || address.startsWith(criteria.getAddress())) {
				Customer customer = new Customer(name, address);
				customers.add(customer);
			}

			scanner.nextLine();

		}
		try {
			scanner = new Scanner(this.file);
		} catch (Exception e) {
			// ignore
		}
		return customers;
	}

	public Customer getById(String name) {
		return null;
	}

}
