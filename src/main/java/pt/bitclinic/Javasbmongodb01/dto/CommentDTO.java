package pt.bitclinic.Javasbmongodb01.dto;

import java.io.Serializable;
import java.time.Instant;

public class CommentDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String text;
	private Instant timeStamp;
	private AuthorDTO author;

	public CommentDTO() {
	}

	public CommentDTO(String text, Instant timeStamp, AuthorDTO author) {
		this.text = text;
		this.timeStamp = timeStamp;
		this.author = author;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Instant getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Instant timeStamp) {
		this.timeStamp = timeStamp;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

}
