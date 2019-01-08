package model;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = Book.GET_ALL_BOOKS_QUERY_NAME, query = "SELECT b FROM Book b")
public class Book extends BaseEntity {
	private static final long serialVersionUID = 1L;

	public static final String GET_ALL_BOOKS_QUERY_NAME = "getAllBooks";

	
	
	private String title;
	@Lob
	private String description;
	private String author;
	private String photoLink;
	private String topic;
	private String location;
	private String isbn;
	private String state;

	public Book() {}

	public Book(String title, String description, String author, String photoLink, String topic, String location,
			String isbn, String state) {
		super();
		this.title = title;
		this.description = description;
		this.author = author;
		this.photoLink = photoLink;
		this.topic = topic;
		this.location = location;
		this.isbn = isbn;
		this.state = state;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPhotoLink() {
		return photoLink;
	}

	public void setPhotoLink(String photoLink) {
		this.photoLink = photoLink;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", description=" + description + ", author=" + author + ", photoLink="
				+ photoLink + ", topic=" + topic + ", location=" + location + ", isbn=" + isbn + ", state=" + state
				+ "]";
	}

	

	
	

	

}
