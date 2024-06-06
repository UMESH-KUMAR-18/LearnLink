import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/fetch")
public class fetch extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public fetch() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Database connection details
        String JDBC_URL = "jdbc:mysql://localhost:3306/studentquery";
        String JDBC_USERNAME = "root";
        String JDBC_PASSWORD = "Unknown@420";

        String column = request.getParameter("column");
        String roll = request.getParameter("rollno");
        int rollno = Integer.parseInt(roll);

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to the database
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);

            pstmt = conn.prepareStatement("SELECT " + column + " FROM upload WHERE rollno = ?");
            pstmt.setInt(1, rollno);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                // Set content type to image/jpeg
                response.setContentType("image/jpeg");

                // Get the image data from the result set and write it to the response output stream
                byte[] imageData = rs.getBytes(column);
                OutputStream outputStream = response.getOutputStream();
                outputStream.write(imageData);
            } else {
                // Image not found
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
