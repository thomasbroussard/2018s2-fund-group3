package fr.epita.bank.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import fr.epita.bank.datamodel.Customer;

public class CustomerJDBCDAO {

	public void create(Customer customer) {
		String sqlCommand = "INSERT INTO CUSTOMER(NAME,ADDRESS) VALUES (?,?)";
		try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			 PreparedStatement insertStatement = connection.prepareStatement(sqlCommand);
			){
			insertStatement.setString(1, customer.getName());
			insertStatement.setString(2, customer.getAddress());
			insertStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void update(Customer customer) {

	}

	public void delete(Customer customer) {

	}

	public List<Customer> search(Customer customer) {
		return null;
	}

	public Customer findById(String name) {
		return null;
	}

}
