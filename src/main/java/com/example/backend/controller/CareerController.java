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
	public List<Career> getAll() {
		return careerService.getAllCareer();
	}
	
	@PostMapping("")
	public Career create(@RequestBody Career career) {
		careerService.createCareer(career);
		return career;
	}
	
	@PutMapping("/{id}")
	public Career update(@RequestBody Career career, @PathVariable Long id) {
		return careerService.updateCareer(career, id);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		if(careerService.deleteCareer(id)) {
			return "Career deleted";
		} else {
			return "Career not found";
		}
	}
	
}
