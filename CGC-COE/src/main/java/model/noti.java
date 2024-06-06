package model;

public class noti {
	private String date;
	private String eventName;
	private String link;
	
	
	
	public noti(String date, String eventName, String link) {
		super();
		this.date = date;
		this.eventName = eventName;
		this.link = link;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	
}
