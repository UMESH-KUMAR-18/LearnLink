import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import Dao.stuDAO;
import model.Student;
import model.event;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private stuDAO studentDAO;
	
	public void init() {
		studentDAO = new stuDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			
			case "AcademicDetails":
				academic(request, response);
				break;
				
			case "stuDetail":
				showEditForm(request, response);
				break;
				
			case "SchoolingDetails":
				school(request, response);
				break;
				
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void academic(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String rollno = request.getParameter("id");
		// Retrieve data from the HTML form
        String semester = request.getParameter("Sem");
        String percentageScoredAcademic = request.getParameter("PercentageScored");
        String month = request.getParameter("Month");
        String numOfSubjects = request.getParameter("NoOfSubjects");
        
        // Create a Student object with the retrieved data
        Student book = new Student(rollno,semester, percentageScoredAcademic, month, numOfSubjects);
		studentDAO.academicUser(book);
		response.sendRedirect(request.getContextPath() + "/StudentServlet?action=list");


	}
	
	private void school(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String rollno = request.getParameter("id");
		// Retrieve data from the HTML form
        String schoolingClass = request.getParameter("schoolingClass");
        String schoolName = request.getParameter("schoolName");
        String percentageScored = request.getParameter("percentageScored");
        String passingYear = request.getParameter("passingYear");
        System.out.println( schoolName + schoolingClass +percentageScored+passingYear);
        
        // Create a Student object with the retrieved data
        Student book = new Student(schoolingClass, schoolName, percentageScored, passingYear);
		studentDAO.schoolUser(book,rollno);
		response.sendRedirect(request.getContextPath() + "/StudentServlet?action=list");


	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Student> listUser = studentDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminDetail1.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminDetail.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		String id = request.getParameter("id");
		Student existingUser = studentDAO.selectUser(id);
		List<Student>  school = studentDAO.selectSchool(id);
		List<Student> academic = studentDAO.selectAcademic(id);
		String action = request.getParameter("action");
		if(action.equals("stuDetail")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("stuDetail.jsp");
			request.setAttribute("user", existingUser);
			request.setAttribute("school", school);
			request.setAttribute("academic", academic);
			
			dispatcher.forward(request, response);
		}else {
	    RequestDispatcher dispatcher = request.getRequestDispatcher("adminDetail.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
		}

	}



	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String id = request.getParameter("id");
		// Retrieve data from the HTML form
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String fatherName = request.getParameter("fatherName");
        String motherName = request.getParameter("motherName");
        String contactNumber = request.getParameter("contactNumber");
        String address = request.getParameter("address");
        String collegeName = request.getParameter("collegeName");
        String course = request.getParameter("course");
        String branch = request.getParameter("branch");
        
        
        // Create a Student object with the retrieved data
        Student book = new Student(id,name, dob, fatherName, motherName, contactNumber, address, collegeName, course,branch);
        
		studentDAO.updateUser(book,id);
		response.sendRedirect(request.getContextPath() + "/StudentServlet?action=list");

	}

}