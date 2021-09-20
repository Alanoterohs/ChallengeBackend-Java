package com.example.backend.service;

import java.util.List;

import com.example.backend.models.Subject;

public interface SubjectService {
	
	public List<Subject> getAllSubject();
	public Subject createSubject(Subject subject);
	public Subject updateSubject(Subject subject, Long id);
	public boolean deleteSubject(Long id);
	
}
