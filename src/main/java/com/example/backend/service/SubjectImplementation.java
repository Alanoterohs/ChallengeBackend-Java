package com.example.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.backend.models.Subject;
import com.example.backend.repository.SubjectRepository;

@Service
public class SubjectImplementation implements SubjectService {

	private SubjectRepository subjectRepository;
	
	public SubjectImplementation(SubjectRepository subjectRepository) {
		this.subjectRepository = subjectRepository;
	}
	
	@Override
	@Transactional
	public List<Subject> getAllSubject() {
		return subjectRepository.findAll();
	}

	@Override
	@Transactional
	public Subject createSubject(Subject subject) {
		subjectRepository.save(subject);
		return subject;
	}

	@Override
	@Transactional
	public Subject updateSubject(Subject subject, Long id) {
		Optional<Subject> subjectOptional = (Optional<Subject>) subjectRepository.findById(id);
		Subject newSubject = subjectOptional.get();
		newSubject.setId(id);
		newSubject.setName(subject.getName());
		newSubject.setDescription(subject.getDescription());
		subjectRepository.save(newSubject);
		return newSubject;
	}

	@Override
	@Transactional
	public String deleteSubject(Long id) {
		if(subjectRepository.existsById(id)) {
			subjectRepository.deleteById(id);
			return "Subject deleted";
		} else {			
			return "Subject not found";
		}
	}

	
	
}
