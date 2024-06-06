package model;

import java.util.Date;

public class Student {
	private String rollno;
    private String name;
    private String dob;
    private String fatherName;
    private String motherName;
    private String contactNumber;
    private String address;
    private String collegeName;
    private String course;
    private String branch;
    
    private String schoolingClass;
    private String schoolName;
    private String percentageScored;
    private String passingYear;
    


	private String semester;
    private String percentageScoredAcademic;
    private String month;
    private String numOfSubjects;
    
    
    public Student(String schoolingClass, String schoolName, String percentageScored, String passingYear) {
		super();
		this.schoolingClass = schoolingClass;
		this.schoolName = schoolName;
		this.percentageScored = percentageScored;
		this.passingYear = passingYear;
	}

    
    
    

	public Student(String rollno, String semester, String percentageScoredAcademic, String month, String numOfSubjects) {
		super();
		this.rollno = rollno;
		this.semester = semester;
		this.percentageScoredAcademic = percentageScoredAcademic;
		this.month = month;
		this.numOfSubjects = numOfSubjects;
	}


	public Student(String rollno, String name, String dob, String fatherName, String motherName, String contactNumber,
			String address, String collegeName, String course, String branch) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.dob = dob;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.contactNumber = contactNumber;
		this.address = address;
		this.collegeName = collegeName;
		this.course = course;
		this.branch = branch;
	}


	public Student(String rollno, String name) {
		super();
		this.rollno = rollno;
		this.name = name;
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getSchoolingClass() {
		return schoolingClass;
	}

	public void setSchoolingClass(String schoolingClass) {
		this.schoolingClass = schoolingClass;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	


	public String getPercentageScored() {
		return percentageScored;
	}





	public void setPercentageScored(String percentageScored) {
		this.percentageScored = percentageScored;
	}





	public String getPassingYear() {
		return passingYear;
	}





	public void setPassingYear(String passingYear) {
		this.passingYear = passingYear;
	}





	public String getSemester() {
		return semester;
	}


	public void setSemester(String semester) {
		this.semester = semester;
	}


	public String getPercentageScoredAcademic() {
		return percentageScoredAcademic;
	}


	public void setPercentageScoredAcademic(String percentageScoredAcademic) {
		this.percentageScoredAcademic = percentageScoredAcademic;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	public String getNumOfSubjects() {
		return numOfSubjects;
	}


	public void setNumOfSubjects(String numOfSubjects) {
		this.numOfSubjects = numOfSubjects;
	}
	
	
    
    
    
    
}
