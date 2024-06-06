package model;

public class mst {
	public int id;
	public String subject;
	public String code;
	public String date;
	
	
	
	public mst(int id, String subject, String code, String date) {
		super();
		this.id = id;
		this.subject = subject;
		this.code = code;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	

}
