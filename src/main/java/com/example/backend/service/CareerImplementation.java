package com.example.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.backend.models.Career;
//import com.example.backend.models.Subject;
import com.example.backend.repository.CareerRepository;
import com.example.backend.repository.SubjectRepository;

@Service
public class CareerImplementation implements CareerService {

	private CareerRepository careerRepository;
	
	//private SubjectRepository subjectRepository;
	
	public CareerImplementation(CareerRepository careerRepository, SubjectRepository subjectRepository) {
		this.careerRepository= careerRepository;
		//this.subjectRepository = subjectRepository;
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
		
//		Optional<E> entityOptional = (Optional<E>) repository.findOne(id);
//		E entity = entityOptional.get();
//		entity = repository.save(entityForm);
		Optional<Career> CareerOptional = (Optional<Career>) careerRepository.findById(id);
		Career newCareer = CareerOptional.get();
		newCareer.setName(career.getName());
		newCareer.setDescription_degree(career.getDescription_degree());
		newCareer.setDuration(career.getDuration());
		newCareer.setSubjects(career.getSubjects());
		careerRepository.save(newCareer);
		return newCareer;
		//System.out.println(id);
//		if(careerRepository.findById(id).isPresent()) {
//			//Career careerUpdated = new Career();
//			//careerUpdated.setId(id);
////			careerUpdated.setName(career.getName());
////			careerUpdated.setDescription_degree(career.getDescription_degree());
////			careerUpdated.setDuration(career.getDuration());
//			//parent.getChildren.addAll(children);
//			careerRepository.save(careerUpdated);
//			return career;
//		} else {
//			return career;
//		}
		
	}

	@Override
	@Transactional
	public boolean deleteCareer(Long id) {
		if(careerRepository.existsById(id)) {
			careerRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	
	
}
