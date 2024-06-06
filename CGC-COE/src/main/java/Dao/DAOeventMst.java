package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;

import model.event;
import model.mst;


public class DAOeventMst {
	 // Database connection details
    String JDBC_URL = "jdbc:mysql://localhost:3306/studentquery";
    String JDBC_USERNAME = "root";
    String JDBC_PASSWORD = "Unknown@420";
    
    private static final String INSERT_USERS_SQL = "INSERT INTO event" + "  (id, name, date) VALUES "
			+ " (?, ?, ?);";
    private static final String INSERT_USERS_SQL1 = "INSERT INTO mst" + "  (id, date, subject, code) VALUES "
			+ " (?, ?, ?,?);";
    private static final String SELECT_ALL_USERS = "select * from event";
    private static final String SELECT_ALL_USERS1 = "select * from mst";
    
    
    protected Connection getConnection() {
		Connection connection = null;
		try {
			// Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
    
  //create or insert user
  	public void insertUser(event newEvent) throws SQLException {
  		System.out.println(INSERT_USERS_SQL);
  		// try-with-resource statement will auto close the connection.
  		try (Connection connection = getConnection();
  				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
  			preparedStatement.setInt(1, newEvent.getId());
  			preparedStatement.setString(2, newEvent.getName());
  			preparedStatement.setString(3, newEvent.getDate());
  			System.out.println(preparedStatement);
  			preparedStatement.executeUpdate();
  		} catch (SQLException e) {
  			e.printStackTrace();
  		}
  	}
  	
  	public void truncate(String table) throws SQLException {
  		try (Connection connection = getConnection();
  				PreparedStatement preparedStatement = connection.prepareStatement("TRUNCATE TABLE "+table+";")) {
  			System.out.println(preparedStatement);
  			preparedStatement.executeUpdate();
  		} catch (SQLException e) {
  			e.printStackTrace();
  		}
  	}
  	
  //select al user
  	public List<event> selectAllUsers() {
  		// using try-with-resources to avoid closing resources (boiler plate code)
  		List<event> users = new ArrayList<>();
  		// Step 1: Establishing a Connection
  		try { 
  			Connection connection = getConnection();

  				// Step 2:Create a statement using connection object
  			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
  			System.out.println(preparedStatement);
  			// Step 3: Execute the query or update query
  			ResultSet rs = preparedStatement.executeQuery();

  			// Step 4: Process the ResultSet object.
  			while (rs.next()) {
  				int id = rs.getInt("id");
  				String name = rs.getString("name");
  				String date = rs.getString("date");
  				users.add(new event(id, name, date));
  			}
  		} catch (SQLException e) {
  			e.printStackTrace();
  		}
  		return users;
  	}
  	
  //select al user
  	public List<mst> selectAllUsers1() {
  		// using try-with-resources to avoid closing resources (boiler plate code)
  		List<mst> users = new ArrayList<>();
  		// Step 1: Establishing a Connection
  		try { 
  			Connection connection = getConnection();

  				// Step 2:Create a statement using connection object
  			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS1);
  			System.out.println(preparedStatement);
  			// Step 3: Execute the query or update query
  			ResultSet rs = preparedStatement.executeQuery();

  			// Step 4: Process the ResultSet object.
  			while (rs.next()) {
  				int id = rs.getInt("id");
  				String subject = rs.getString("subject");
  				String code = rs.getString("code");
  				String date = rs.getString("date");
  				users.add(new mst(id, subject, code,date));
  			}
  		} catch (SQLException e) {
  			e.printStackTrace();
  		}
  		return users;
  	}
  	
  //create or insert user
  	public void insertUser1(mst newmst) throws SQLException {
  		System.out.println(INSERT_USERS_SQL);
  		// try-with-resource statement will auto close the connection.
  		try (Connection connection = getConnection();
  				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL1)) {
  			preparedStatement.setInt(1, newmst.getId());
  			preparedStatement.setString(2, newmst.getDate());
  			preparedStatement.setString(3, newmst.getSubject());
  			preparedStatement.setString(4, newmst.getCode());
  			System.out.println(preparedStatement);
  			preparedStatement.executeUpdate();
  		} catch (SQLException e) {
  			e.printStackTrace();
  		}
  	}
}
