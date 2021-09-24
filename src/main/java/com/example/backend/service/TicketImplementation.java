package com.example.backend.service;

import javax.transaction.Transactional;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.backend.models.Ticket;
import com.google.gson.Gson;
import com.google.api.client.util.Base64;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@Service
public class TicketImplementation {

//	/api/v2/tickets/{ticket_id}/comments
	
	final static String URL = "https://teclab1593636133.zendesk.com/api/v2/tickets/";	

	private static HttpHeaders getHeaders ()
    {
		
        String userCredentials = "jorge.danni@teclab.edu.ar:Abril2021*"; //"adminuser:adminpassword";
        String encodedCredentials =
                new String(Base64.encodeBase64(userCredentials.getBytes())); 
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Basic " + encodedCredentials); //Se crea [Auth Basic code]
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }
	
	
	@Transactional
	public static Ticket getComments(Long id) throws Exception {
		
		try {			
			
//			curl https://teclab1593636133.zendesk.com/api/v2/tickets/42/comments.json \
	        RestTemplate restTemplate = new RestTemplate();
	        String REST_SERVICE_URL = URL + id + "/comments.json";
	        HttpHeaders httpHeaders = getHeaders();
	        
	        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
	        ResponseEntity<String> responseEntity = restTemplate.exchange(REST_SERVICE_URL, HttpMethod.GET, httpEntity, String.class);
	        String data = responseEntity.getBody();
	        System.out.println(data);
            Gson gson = new Gson();
	        Ticket ticket = gson.fromJson(data, Ticket.class); 
            
	        return ticket;
	        
		} catch (Exception e) {
			throw new Exception();
		}
		
	}
    
	
}
