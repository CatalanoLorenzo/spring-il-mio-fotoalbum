package org.java.app.db;

import org.hibernate.validator.constraints.Length;
import org.java.app.api.dto.MessageDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 120, nullable = false)
	@Length(min = 3, max = 120)
	@NotNull
	private String text;
	@Column(length = 120, nullable = false)
	@Length(min = 5, max = 120)
	@NotNull
	@Email
	private String email;
	
	public Message() {}
	public Message(String text,String email) {
		setText(text);
		setEmail(email);
	}

	public Message(MessageDTO messageDTO) {
		setText(messageDTO.getText());
		setEmail(messageDTO.getEmail());
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
}
