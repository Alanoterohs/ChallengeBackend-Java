package com.example.backend.models;

import java.util.List;

public class Ticket {

	private List<Comment> comments;

	public List<Comment> getComment() {
		return comments;
	}

	public void setComment(List<Comment> comment) {
		this.comments = comment;
	}
	
}
