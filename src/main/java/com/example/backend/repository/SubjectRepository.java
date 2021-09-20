package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.models.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
	
}
