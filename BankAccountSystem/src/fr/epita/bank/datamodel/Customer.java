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
	private String name;
	private String address;

	private List<Account> accountsList;

	public Customer(String name, String address) {
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + ", accountsList=" + accountsList + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Account> getAccountsList() {
		return accountsList;
	}

	public void setAccountsList(List<Account> accountsList) {
		this.accountsList = accountsList;
	}
	


}
