package Dao;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.mst;


public class uploadDao {
	 // Database connection details
    String JDBC_URL = "jdbc:mysql://localhost:3306/studentquery";
    String JDBC_USERNAME = "root";
    String JDBC_PASSWORD = "Unknown@420";
   
     
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
  	public int insertData(InputStream inputStream,String columnName,int rollno) throws SQLException {
  		int row=0;
  		// try-with-resource statement will auto close the connection.
  		try (Connection connection = getConnection();
  				PreparedStatement preparedStatement = connection.prepareStatement("UPDATE upload SET " + columnName + " = ? WHERE rollno = ?")) {
  			if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
  				preparedStatement.setBlob(1, inputStream);
            }
  			preparedStatement.setInt(2, rollno);
  			row=preparedStatement.executeUpdate();
  		} catch (SQLException e) {
  			e.printStackTrace();
  		}
  		return row;
  	}
  	
  	//
  	public String pdf(String columnName,int rollno) throws SQLException {
  		String base64Pdf=null;
  		// try-with-resource statement will auto close the connection.
  		try (Connection connection = getConnection();
  				PreparedStatement preparedStatement = connection.prepareStatement("Select " + columnName + " from upload WHERE rollno = ?")) {
  			
  			preparedStatement.setInt(1, rollno);
  			System.out.println(preparedStatement);
  			ResultSet rs= preparedStatement.executeQuery();
  			
  			if (rs.next()) {
                Blob blob = rs.getBlob(columnName);
                if(blob==null) {
                	return null;
                }
                byte[] pdfData = blob.getBytes(1, (int) blob.length());

                // Convert binary data to Base64
                base64Pdf = java.util.Base64.getEncoder().encodeToString(pdfData);

            }
  			
  		}
  		return base64Pdf;
  		}
}