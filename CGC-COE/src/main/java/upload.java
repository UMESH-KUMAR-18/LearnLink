import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.uploadDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB
public class upload extends HttpServlet {
	
	String action=null;
	int rollno=0;

    private static final long serialVersionUID = 1L;

 private uploadDao fileUploadDao;

    @Override
    public void init() {
        fileUploadDao = new uploadDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward GET requests to doPost method
        doPost(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	action = request.getParameter("action");
    	String roll = request.getParameter("rollno");
    	rollno=Integer.parseInt(roll);
    	String type =request.getParameter("type");

		System.out.println(action);
		System.out.println(rollno);
		System.out.println(type);
		

		switch (type) {
		case "image":
			try {
				insert(request, response);
			} catch (IOException | ServletException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case "pdf":
			try {
				pdf(request, response);
			} catch (IOException | ServletException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}
    
    	
        private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        	  // Get the image data from the request
        	System.out.println("calling");
            Part filePart = request.getPart(action);
            InputStream inputStream = filePart.getInputStream();
            
        	int rowsAffected = fileUploadDao.insertData(inputStream,action,rollno);
            if (rowsAffected > 0) {
                response.getWriter().println("Image uploaded successfully!");
            } else {
                response.getWriter().println("Failed to upload image!");
            }
         }
        
        private void pdf(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
      	  // Get the image data from the request
          
      	String base64Pdf = fileUploadDao.pdf(action,rollno);
      	if(base64Pdf==null) {
      		 response.getWriter().println("You have not uploaded anything! Please upload a PDF.");
      		 return;
      	}
      	 request.setAttribute("base64Pdf", base64Pdf);
      	 request.getRequestDispatcher("Message.jsp").forward(request, response);
      	 
       }
}