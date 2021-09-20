package com.example.backend.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "careers")
public class Career implements Serializable {
	
	private static final long serialVersionUID = 1l;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description_degree;
	private Integer duration;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "careers")
    private List<Subject> subject;
	
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
	
	
	public String getDescription_degree() {
		return description_degree;
	}
	public void setDescription_degree(String description_degree) {
		this.description_degree = description_degree;
	}
	
	
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
	//@JsonManagedReference
	public List<Subject> getSubjects() {
		return subject;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subject = subjects;
	}

}
