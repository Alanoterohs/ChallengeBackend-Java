package com.example.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Subject>> get() {
		try {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(subjectService.getAllSubject());
		} catch (Exception e) {			
			return new ResponseEntity<List<Subject>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("")
	public ResponseEntity<Subject> create(@RequestBody Subject subject) {
		try {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(subjectService.createSubject(subject));
		} catch (Exception e) {			
			return new ResponseEntity<Subject>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Subject subject, @PathVariable Long id) {
		try {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(subjectService.updateSubject(subject, id));
		} catch (Exception e) {			
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Error Message: subject not found");
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id) {
		try {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(subjectService.deleteSubject(id));
		} catch (Exception e) {			
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Error Message: subject not found");
		}
	}	
}
