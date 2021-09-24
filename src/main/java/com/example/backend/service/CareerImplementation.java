package com.example.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.backend.models.Career;
import com.example.backend.repository.CareerRepository;


@Service
public class CareerImplementation implements CareerService {

	private CareerRepository careerRepository;
	
	public CareerImplementation(CareerRepository careerRepository) {
		this.careerRepository= careerRepository;
	}
	
	@Override
	@Transactional
	public List<Career> getAllCareer() {
			return careerRepository.findAll();			
	}

	@Override
	@Transactional
	public Career createCareer(Career career) {
		careerRepository.save(career);
		return career;
	}

	@Override
	@Transactional
	public Career updateCareer(Career career, Long id) {
		Optional<Career> CareerOptional = (Optional<Career>) careerRepository.findById(id);
		Career newCareer = CareerOptional.get();
		newCareer.setName(career.getName());
		newCareer.setDescription_degree(career.getDescription_degree());
		newCareer.setDuration(career.getDuration());
		newCareer.setSubjects(career.getSubjects());
		careerRepository.save(newCareer);
		return newCareer;
	}

	@Override
	@Transactional
	public String deleteCareer(Long id) {
		if(careerRepository.existsById(id)) {
			careerRepository.deleteById(id);
			return "Career deleted";
		} else {
			return "Career not found";
		}
	}
	
	
}
