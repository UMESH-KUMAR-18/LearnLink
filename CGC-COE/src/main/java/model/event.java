package model;

public class event {
	public int id;
	public String name;
	public String date;
	
	
	public event(int id, String name, String date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	

}
