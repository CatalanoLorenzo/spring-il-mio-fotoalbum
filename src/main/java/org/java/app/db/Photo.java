package org.java.app.db;

import java.util.Arrays;
import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.java.app.mvc.auth.pojo.User;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "photo")
public class Photo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 120, nullable = false)
	@Length(min = 3, max = 120)
	@NotNull
	private String title;

	@Column(length = 255, nullable = true)
	@Length(min = 3, max = 255)

	private String description;

	@Column(length = 255, nullable = true)
	@Length(min = 10, max = 255)
	private String url;

	@Column(nullable = false)
	private boolean visible;

	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToMany
	@JsonManagedReference
	private List<Category> categories;

	public Photo() {
	}

	public Photo(String title, String description, String url, User  user, Category... categories) {
		setTitle(title);
		setDescription(description);
		setUrl(url);
		setVisible(true);
		setCategories(Arrays.asList(categories));
		setUser(user);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	};

	@Override
	public String toString() {

		return "[" + getId() + "] Photo:\n" + "title: " + getTitle() + "\n" + "description: " + getDescription() + "\n"
				+ "url: " + getUrl() + "\n" + "is visible?: " + isVisible() + "\n" + "Categories: " + getCategories();
	}
}
