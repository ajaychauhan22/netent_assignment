package com.netent.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author ajaychauhan01
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coverage {
	private int userId;
	private int id;
	private String title;
	private String body;

	public Coverage() {
	}

	public Coverage(int userId, int id, String title, String body) {
		super();
		this.userId = userId;
		this.id = id;
		this.title = title;
		this.body = body;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Coverage [userId=" + userId + ", id=" + id + ", title=" + title + ", body=" + body + "]";
	}
}