

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import Dao.DAOeventMst;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.event;
import model.mst;


public class eventMst extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOeventMst emDAO;
	
	public void init() {
		emDAO = new DAOeventMst();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);

		try {
			switch (action) {
			case "/insert":
				insertUser(request, response);
				break;
			case "event":
				truncate(request, response);
				break;
			case "mst":
				truncate(request, response);
				break;
			case "/list":
				listUser(request, response);
				break;
			case "/insertMST":
				insertUser1(request, response);
				break;
			case "/listMST":
				listUser1(request, response);
				break;
			case "/dashlist":
				dashlistUser(request, response);
				break;
			case "/dashlistMST":
				dashlistUser1(request, response);
				break;
			default:
				response.sendRedirect("mstEvent.jsp");
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listUser1(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<mst> listUser = emDAO.selectAllUsers1();
		request.setAttribute("eventList", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("mstEvent.jsp");
		dispatcher.forward(request, response);
	}


	private void insertUser1(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String subject = request.getParameter("subject");
		String code = request.getParameter("subCode");
		String date = request.getParameter("date");
		mst newmst = new mst(id, subject, code,date);
		emDAO.insertUser1(newmst);
		response.sendRedirect(request.getContextPath() + "/eventMst?action=/listMST");
	}


	private void truncate(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String table = request.getParameter("action");
		emDAO.truncate(table);
		response.sendRedirect(request.getContextPath() + "/eventMst?action=/list");
		
	}


	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<event> listUser = emDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("mstEvent.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("eventName");
		String date = request.getParameter("date");
		event newEvent = new event(id, name, date);
		emDAO.insertUser(newEvent);
		response.sendRedirect(request.getContextPath() + "/eventMst?action=/list");
	}
	
	private void dashlistUser1(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<mst> listUser = emDAO.selectAllUsers1();
		request.setAttribute("eventList", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
		dispatcher.forward(request, response);
	}

	private void dashlistUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<event> listUser = emDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
		dispatcher.forward(request, response);
	}


	}

