package model;

public class User {
	public int id;
	public String username;
	public String email;
	public String passowrd;
	
	
	public User() {
		super();
	}



	public User(String username, String email, String passowrd) {
		super();
		this.username = username;
		this.email = email;
		this.passowrd = passowrd;
	}
	
	
	
	public User(int id, String username, String email, String passowrd) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.passowrd = passowrd;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassowrd() {
		return passowrd;
	}
	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", passowrd=" + passowrd + "]";
	}
	
	
	

}
