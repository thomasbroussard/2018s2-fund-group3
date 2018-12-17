package fr.epita.bank.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.service.CustomerJDBCDAO;

public class TestCustomerToDataBase {

	public static void main(String[] args) throws SQLException {
		//testSearchCustomerFromDB();
		
		CustomerJDBCDAO dao = new CustomerJDBCDAO();
		dao.create(new Customer("Jessica", "MAISONS-ALFORT"));
		testSearchCustomerFromDB();
	}

	private static void testInsertIntoDatabase() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		String sqlCommand = "INSERT INTO CUSTOMER(NAME,ADDRESS) VALUES ('Clément','MONTREUIL')";
		PreparedStatement insertStatement = connection.prepareStatement(sqlCommand);
		insertStatement.execute();
		
		connection.close();
		insertStatement.close();
		
		testSearchCustomerFromDB();
	}

	private static void testSearchCustomerFromDB() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		System.out.println(connection.getSchema());
		String selectQuery = "select NAME,ADDRESS from CUSTOMER";

		// PreparedStatement is preferred to prevent SQL injections
		PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
		ResultSet results = preparedStatement.executeQuery();

		while (results.next()) {
			String column1 = results.getString("NAME");
			String column2 = results.getString("ADDRESS");
			System.out.println(column1);
			System.out.println(column2);
		}
		preparedStatement.close();
		results.close();
		connection.close();
	}

}
