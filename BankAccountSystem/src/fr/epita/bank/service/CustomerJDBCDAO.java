package fr.epita.bank.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.epita.bank.datamodel.Customer;

public class CustomerJDBCDAO {

	public void create(Customer customer) {
		String sqlCommand = "INSERT INTO CUSTOMER(NAME,ADDRESS) VALUES (?,?)";
		try (Connection connection = getConnection();
				PreparedStatement insertStatement = connection.prepareStatement(sqlCommand);) {
			insertStatement.setString(1, customer.getName());
			insertStatement.setString(2, customer.getAddress());
			insertStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void update(Customer customer) {
		String updateQuery = "UPDATE CUSTOMER SET ADDRESS=? WHERE NAME=?";

		
		try (Connection connection = getConnection();
			PreparedStatement updateStatement = connection.prepareStatement(updateQuery)){
			updateStatement.setString(1, customer.getAddress());
			updateStatement.setString(2, customer.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private Connection getConnection() throws SQLException {
		Configuration conf = Configuration.getInstance();
		String jdbcUrl = conf.getConfigurationValue("jdbc.url");
		String user = conf.getConfigurationValue("jdbc.user");
		String password = conf.getConfigurationValue("jdbc.password");
		Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
		return connection;
	}

	public void delete(Customer customer) {
		String deleteQuery = "DELETE CUSTOMER WHERE NAME=?";
		try (Connection connection = getConnection();
			PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)){
			deleteStatement.setString(1, customer.getName());
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Customer> search(Customer customer) {
		List<Customer> resultList = new ArrayList<Customer>();
		String selectQuery = "select NAME,ADDRESS from CUSTOMER WHERE NAME LIKE ? OR ADDRESS = ?";
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
				) {

			preparedStatement.setString(1, customer.getName()+"%");
			preparedStatement.setString(2, customer.getAddress());
			ResultSet results = preparedStatement.executeQuery();
			while (results.next()) {
				String name = results.getString("NAME");
				String address = results.getString("ADDRESS");
				Customer currentCustomer = new Customer(name, address);
				resultList.add(currentCustomer);
			}
			results.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}

	public Customer findById(String name) {
		return null;
	}

}
