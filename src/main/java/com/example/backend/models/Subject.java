package com.example.backend.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subjects")
public class Subject implements Serializable {
	
	private static final long serialVersionUID = 1l;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Long careers_id;	
	
    @ManyToOne
    @JoinColumn(name = "careers_id", insertable=false, updatable=false)
	private Career careers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@JsonBackReference
	public Career getCareers() {
		return careers;
	}

	public void setCareers(Career careers) {
		this.careers = careers;
	}

	public Long getCareers_id() {
		return careers_id;
	}

	public void setCareers_id(Long careers_id) {
		this.careers_id = careers_id;
	}
	
}
