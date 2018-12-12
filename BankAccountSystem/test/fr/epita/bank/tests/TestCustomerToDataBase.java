package fr.epita.bank.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestCustomerToDataBase {

	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","");
		System.out.println(connection.getSchema());
		connection.close();
	}

}
