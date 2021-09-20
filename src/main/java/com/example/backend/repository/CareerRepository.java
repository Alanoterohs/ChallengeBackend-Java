package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.models.Career;

@Repository
public interface CareerRepository extends JpaRepository<Career, Long> {
}
