package com.example.backend.service;

import java.util.List;
import com.example.backend.models.Career;


public interface CareerService {
	
	public List<Career> getAllCareer();
	public Career createCareer(Career career);
	public Career updateCareer(Career career, Long id);
	public boolean deleteCareer(Long id);
}
