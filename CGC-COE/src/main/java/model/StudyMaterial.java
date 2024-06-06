package model;

public class StudyMaterial {
    private int id;
    private String title;
    private String description;
    private String filePath;
    private String uploadDate;

    
    public StudyMaterial(int id, String title, String description, String filePath, String uploadDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.filePath = filePath;
        this.uploadDate = uploadDate;
    }

	public StudyMaterial() {
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }
}
