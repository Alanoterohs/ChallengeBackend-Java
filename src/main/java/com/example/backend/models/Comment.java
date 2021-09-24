package com.example.backend.models;

public class Comment {
	
	private Long id;
	private String body;
	private Long author_id;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(Long author_id) {
		this.author_id = author_id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

	
}
