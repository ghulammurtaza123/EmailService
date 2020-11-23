package com.email.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.model.EmailRequest;
import com.email.service.EmailService;

@RestController
@CrossOrigin
public class EmailController {
	
	
     @Autowired
	private EmailService emailServ;
	
	@GetMapping("/home")
  public String welcome() {
	
	  return "This is my email api";
}
	
	@PostMapping("/sendemail")
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request) {
		
		emailServ.sendEmail(request.getSubject(),request.getMessage(),request.getto());
		
		System.out.println(request);
		
		return ResponseEntity.ok("done..");
		
	}
}
