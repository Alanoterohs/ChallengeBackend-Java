package com.example.backend.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.dto.Ejemplo;
import com.example.backend.service.PruebaService;


@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "*")
public class PruebaController {

	@Autowired
	protected PruebaService pruebaService;

	@GetMapping("/ejemplo")
	public ResponseEntity<Ejemplo> getMessageStatus(@RequestParam(value ="nombre") String nombre) {
		try {
			Ejemplo ejemplo = new Ejemplo();
			ejemplo.setNombre(nombre);
			return ResponseEntity.ok(ejemplo);
		}catch (Exception e){
			System.out.println( "Se ha producido un error" );
			throw e;
		}
	}
	
}


