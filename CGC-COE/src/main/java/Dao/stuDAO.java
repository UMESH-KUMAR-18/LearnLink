package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Student;
import model.User;

public class stuDAO {
	 // Database connection details
    String JDBC_URL = "jdbc:mysql://localhost:3306/studentquery";
    String JDBC_USERNAME = "root";
    String JDBC_PASSWORD = "Unknown@420";
    
    private static final String INSERT_STUDENT_SQL = "INSERT INTO student (Name, DOB, FatherName, MotherName, ContactNumber, Address, CollegeName, Course, Branch) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_STUDENT_BY_ID = "SELECT * FROM student WHERE rollno = ?";
    
    private static final String School = "SELECT * FROM SchoolingDetails WHERE rollno = ?";
    
    private static final String Academic = "SELECT * FROM AcademicDetails WHERE rollno = ?";

    private static final String SELECT_ALL_STUDENTS = "SELECT * FROM student";

    private static final String UPDATE_STUDENT_SQL = "UPDATE student SET Name = ?, DOB = ?, FatherName = ?, MotherName = ?, ContactNumber = ?, Address = ?, CollegeName = ?, Course = ?, Branch = ? WHERE rollno = ?;";

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
	

	//update user
	 public boolean updateUser(Student user, String id) throws SQLException {
	        boolean rowUpdated;
	        try (Connection connection = getConnection();
	             PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENT_SQL)) {
	        	System.out.println(id);
	            statement.setString(1, user.getName());
	            statement.setString(2, user.getDob());
	            statement.setString(3, user.getFatherName());
	            statement.setString(4, user.getMotherName());
	            statement.setString(5, user.getContactNumber());
	            statement.setString(6, user.getAddress());
	            statement.setString(7, user.getCollegeName());
	            statement.setString(8, user.getCourse());
	            statement.setString(9, user.getBranch());
	            statement.setString(10, id);
	            System.out.println(statement);
	            rowUpdated = statement.executeUpdate() > 0;
	        }
	        return rowUpdated;
	    }
	 
	//update user academic
		 public boolean academicUser(Student user) throws SQLException {
		        boolean rowUpdated = false;
		        String checkQuery = "SELECT COUNT(*) AS count FROM AcademicDetails WHERE rollno = ? AND Sem = ?";
		        try (Connection connection = getConnection();
		             PreparedStatement statement = connection.prepareStatement(checkQuery)) {
		        	statement.setString(1, user.getRollno()); // Replace "2019246" with your actual rollno
		        	statement.setString(2, user.getSemester());
		        	
		        	ResultSet resultSet = statement.executeQuery();
		            if (resultSet.next()) {
		            	int count = resultSet.getInt("count");
		                if (count == 0) {
		                    // If no record exists, proceed with the INSERT operation
		                    String insertQuery = "INSERT INTO AcademicDetails (rollno, Sem, PercentageScored, Month, NoOfSubjects) VALUES (?, ?, ?, ?, ?)";
		                    try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
		                    	
		                        insertStatement.setString(1, user.getRollno()); 
		                        insertStatement.setString(2, user.getSemester()); 
		                        insertStatement.setString(3, user.getPercentageScoredAcademic());
		                        insertStatement.setString(4, user.getMonth()); 
		                        insertStatement.setString(5, user.getNumOfSubjects()); 
		                        rowUpdated = insertStatement.executeUpdate()>0;

		            }
		          }
		        }
		       }
		        return rowUpdated;
		    }
		 
		//update user academic
		 public boolean schoolUser(Student user,String rollno) throws SQLException {
		        boolean rowUpdated = false;
		        String checkQuery = "SELECT COUNT(*) AS count FROM SchoolingDetails WHERE rollno = ? AND Class = ?";
		        try (Connection connection = getConnection();
		             PreparedStatement statement = connection.prepareStatement(checkQuery)) {
		        	statement.setString(1, user.getRollno()); // Replace "2019246" with your actual rollno
		        	statement.setString(2, user.getSchoolingClass());
		        	
		        	ResultSet resultSet = statement.executeQuery();
		            if (resultSet.next()) {
		            	int count = resultSet.getInt("count");
		                if (count == 0) {
		                    // If no record exists, proceed with the INSERT operation
		                	 String insertQuery = "INSERT INTO SchoolingDetails (rollno, Class, SchoolName, PercentageScored, PassingYear) VALUES (?, ?, ?, ?, ?)";
			                    try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
			                    	
			                        insertStatement.setString(1, rollno); 
			                        insertStatement.setString(2, user.getSchoolingClass()); 
			                        insertStatement.setString(3, user.getSchoolName());
			                        insertStatement.setString(4, user.getPercentageScored()); 
			                        insertStatement.setString(5, user.getPassingYear()); 
			                        System.out.println(insertStatement);
			                        rowUpdated = insertStatement.executeUpdate()>0;

		            }
		          }
		        }
		       }
		        return rowUpdated;
		    }
	
	//select user by id
	  public Student selectUser(String id) {
	        Student user = null;
	        try (Connection connection = getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID)) {
	            preparedStatement.setString(1, id);
	            System.out.println(preparedStatement);
	            ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next()) {
	                String name = rs.getString("Name");
	                String dob = rs.getString("DOB");
	                String fatherName = rs.getString("FatherName");
	                String motherName = rs.getString("MotherName");
	                String contactNumber = rs.getString("ContactNumber");
	                String address = rs.getString("Address");
	                String collegeName = rs.getString("CollegeName");
	                String course = rs.getString("Course");
	                String branch = rs.getString("Branch");
	                
	               
	                user = new Student(id,name, dob, fatherName, motherName, contactNumber, address, collegeName, course,
	                        branch);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return user;
	    }
	  
	  //select Schooling
	  public List<Student> selectSchool(String id) {
			// using try-with-resources to avoid closing resources (boiler plate code)
			List<Student> users = new ArrayList<>();
			// Step 1: Establishing a Connection
			try { 
				Connection connection = getConnection();

					// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(School);
				preparedStatement.setString(1, id);
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					String Class = rs.getString("Class");
					String SchoolName = rs.getString("SchoolName");
					System.out.println(SchoolName);
					String PercentageScored = rs.getString("PercentageScored");
					String PassingYear = rs.getString("PassingYear");
					users.add(new Student(id, Class, SchoolName, PercentageScored,PassingYear));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return users;
		}
	  
	  //select academic
	  public List<Student> selectAcademic(String id) {
			// using try-with-resources to avoid closing resources (boiler plate code)
			List<Student> users = new ArrayList<>();
			// Step 1: Establishing a Connection
			try { 
				Connection connection = getConnection();

					// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(Academic);
				preparedStatement.setString(1, id);
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					String Sem = rs.getString("Sem");
					String PercentageScored = rs.getString("PercentageScored");
					String Month = rs.getString("Month");
					String NoOfSubjects = rs.getString("NoOfSubjects");
					users.add(new Student(id, Sem, PercentageScored, Month,NoOfSubjects));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return users;
		}
	  
	  
	
	//select all user
	  public List<Student> selectAllUsers() {
	        List<Student> users = new ArrayList<>();
	        try (Connection connection = getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS)) {
	            ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next()) {
	            	String rollno=rs.getString("rollno");
	            	String name = rs.getString("name");
	                users.add(new Student(rollno,name));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return users;
	    }
	
	

}

