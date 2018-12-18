package fr.epita.quiz.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.epita.quiz.datamodel.Question;

public class QuestionJDBCDAO {
	

	public void create(Question question) {
		String sqlCommand = "INSERT INTO QUESTION() VALUES ()";
		try (Connection connection = getConnection();
				PreparedStatement insertStatement = connection.prepareStatement(sqlCommand);) {
			
			
			insertStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void update(Question question) {
		String updateQuery = "UPDATE QUESTION SET  WHERE ";

		
		try (Connection connection = getConnection();
			PreparedStatement updateStatement = connection.prepareStatement(updateQuery)){
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

	public void delete(Question Question) {
		String deleteQuery = "DELETE QUESTION WHERE NAME=?";
		try (Connection connection = getConnection();
			PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)){
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Question> search(Question Question) {
		List<Question> resultList = new ArrayList<Question>();
		String selectQuery = "select  from QUESTION WHERE ";
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
				) {

		
			ResultSet results = preparedStatement.executeQuery();
			while (results.next()) {

				Question currentQuestion = new Question();
				resultList.add(currentQuestion);
			}
			results.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}

}
