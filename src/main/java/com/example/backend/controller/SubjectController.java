package com.example.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.models.Subject;
import com.example.backend.service.SubjectService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/subjects")
public class SubjectController {

	private SubjectService subjectService;
	
	public SubjectController(SubjectService subjectService) {
		this.subjectService = subjectService;
	}
	
	@GetMapping("")
	public List<Subject> get() {
		return subjectService.getAllSubject();
	}
	
	@PostMapping("")
	public Subject create(@RequestBody Subject subject) {
		subjectService.createSubject(subject);
		return subject;
	}
	
	@PutMapping("/{id}")
	public Subject update(@RequestBody Subject subject, @PathVariable Long id) {
		subjectService.updateSubject(subject, id);
		return subject;
	}
	
	@DeleteMapping("/{id}")
	public String update(@PathVariable Long id) {
		if(subjectService.deleteSubject(id)) {
			return "Subject deleted";
		} else {
			return "Subject not found";
		}
	}	
}
