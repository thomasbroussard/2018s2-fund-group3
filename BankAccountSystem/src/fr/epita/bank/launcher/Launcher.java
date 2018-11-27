package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.Customer;

public class Launcher {
	
	public static void main(String[] args) {
		Customer thomas = new Customer("Thomas","Paris");
		Customer thomas2 = new Customer("Thomas","Paris");
		
		
		
		System.out.println(thomas);
		System.out.println(thomas2);
	}

}
