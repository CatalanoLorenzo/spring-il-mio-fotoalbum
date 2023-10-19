package org.java.app.api.dto;

public class MessageDTO {
	private int id;
	private String text;
	private String email;
	public MessageDTO() {}
	public MessageDTO(String text,String email) {
		setEmail(email);
		setText(text);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		
		return  "id: " + getId()
				+ "\n Text: " + getText() 
				+ "\n email: " + getEmail();
	}
}
