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
	public String getDescription() {
		return body;
	}
	public void setDescription(String description) {
		this.body = description;
	}
	public Long getId_author() {
		return author_id;
	}
	public void setId_author(Long id_author) {
		this.author_id = id_author;
	}
	
}
