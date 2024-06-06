package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.StudyMaterial;

public class StudyMaterialDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/studentquery";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Unknown@420";
    

    private static final String INSERT_MATERIAL_SQL = "INSERT INTO study_materials (title, description, file_path) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_MATERIALS = "SELECT * FROM study_materials";
    private static final String DELETE_MATERIAL_SQL = "DELETE FROM study_materials WHERE id = ?";
    private static final String SELECT_MATERIAL_BY_ID = "SELECT * FROM study_materials WHERE id = ?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertMaterial(StudyMaterial material) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MATERIAL_SQL)) {
            preparedStatement.setString(1, material.getTitle());
            preparedStatement.setString(2, material.getDescription());
            preparedStatement.setString(3, material.getFilePath());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public List<StudyMaterial> selectAllMaterials() {
        List<StudyMaterial> materials = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MATERIALS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                String filePath = rs.getString("file_path");
                String uploadDate = rs.getTimestamp("upload_date").toString();
                materials.add(new StudyMaterial(id, title, description, filePath, uploadDate));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return materials;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}