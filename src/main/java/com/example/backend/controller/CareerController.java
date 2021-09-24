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

import com.example.backend.models.Career;
import com.example.backend.service.CareerService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/career")
public class CareerController {

	private CareerService careerService;
	
	public CareerController(CareerService careerService) {
		this.careerService = careerService;
	}
	
	@GetMapping("")
	public ResponseEntity<List<Career>> getAll() {
		try {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(careerService.getAllCareer());
		} catch (Exception e) {			
			return new ResponseEntity<List<Career>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("")
	public ResponseEntity<Career> create(@RequestBody Career career) {
		try {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(careerService.createCareer(career));
		} catch(Exception e) {
			return new ResponseEntity<Career>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Career career, @PathVariable Long id) {
		try {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(careerService.updateCareer(career, id));
		} catch(Exception e) {
	        return ResponseEntity
	                .status(HttpStatus.NOT_FOUND)
	                .body("Error Message: id not found");
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(careerService.deleteCareer(id));
		} catch(Exception e) {
	        return ResponseEntity
	                .status(HttpStatus.NOT_FOUND)
	                .body("Error Message: id not found");
		}
	}
	
}
