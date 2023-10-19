package org.java.app.db;

import java.util.Arrays;
import java.util.List;

import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 120, nullable = false)
	@Length(min = 3, max = 120)
	@NotNull
	private String title;
	
	@ManyToMany
	@JsonBackReference
	private List<Photo> photos;
	
	
	public Category(){}
	
	public Category(String title,Photo...photos ){
		setTitle(title);
		setPhotos(Arrays.asList(photos));
	}




	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

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

	
	@Override
	public String toString() {

		return "[" + getId() + "] Photo:\n"
					+ "title: " + getTitle();
					
	}
}
