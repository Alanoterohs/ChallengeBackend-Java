package com.example.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.backend.service.TicketImplementation;

@RestController
@RequestMapping("/ticket")
@CrossOrigin(origins = "*")
public class TicketController {

	
	protected TicketImplementation ticketImplementation;
	
	public TicketController(TicketImplementation ticketImplementation) {
		this.ticketImplementation = ticketImplementation;
	}
	
	@GetMapping("/comments")
    public ResponseEntity<?> comments(@RequestParam(value ="id")Long id) {
		try {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(TicketImplementation.getComments(id));			
		}catch (Exception e){
	        return ResponseEntity
	                .status(HttpStatus.NOT_FOUND)
	                .body("Error Message: id not found");
		}
	}
	
	@PutMapping("/addComment")
	public ResponseEntity<?> addComment(@RequestParam(value = "id") Long id, @RequestParam(value = "body") String body) {
		try {
			return ResponseEntity
					.status(HttpStatus.ACCEPTED)
					.body(TicketImplementation.addComment(id, body));
		} catch (Exception e) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body("Error: Ticket not found");
		}
	}
	
	
}