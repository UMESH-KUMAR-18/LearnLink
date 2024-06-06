
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.StudyMaterial;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import Dao.StudyMaterialDAO;

@WebServlet("/StudyMaterialServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class StudyMaterialServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudyMaterialDAO studyMaterialDAO;

    public void init() {
        studyMaterialDAO = new StudyMaterialDAO();
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
                case "UPLOAD":
                    uploadMaterial(request, response);
                    break;
                case "list":
                    uploadMaterial(request, response);
                    break;
          
                default:
                    listMaterials(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void uploadMaterial(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Part filePart = request.getPart("file");
        String fileName = extractFileName(filePart);
        System.out.println("on the way");
        String savePath = "C:\\Users\\Umesh Thakur\\Desktop\\webdev\\CGC-COE\\src\\main\\resources" + File.separator + fileName;
        System.out.println(savePath);

        File fileSaveDir = new File(savePath);
        filePart.write(savePath);
        
        StudyMaterial newMaterial = new StudyMaterial();
        newMaterial.setTitle(title);
        newMaterial.setDescription(description);
        newMaterial.setFilePath(savePath);
        studyMaterialDAO.insertMaterial(newMaterial);

        response.sendRedirect("adminstumaterial.jsp"); // Redirect to the admin page
    }

    private void listMaterials(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<StudyMaterial> listMaterials = studyMaterialDAO.selectAllMaterials();
        request.setAttribute("listMaterials", listMaterials);
        request.getRequestDispatcher(request.getParameter("re")).forward(request, response);
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}
