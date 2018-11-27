/**
 * 
 */
package fr.epita.bank.datamodel;

import java.util.List;

/**
 * @author tbrou
 *
 */
public class Customer {
	String name;
	String address;
	
	List<Account> accountsList;

	public Customer(String name, String address) {
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + ", accountsList=" + accountsList + "]";
	}
	


}
