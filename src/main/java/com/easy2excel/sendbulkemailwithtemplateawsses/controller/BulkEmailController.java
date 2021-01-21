package com.easy2excel.sendbulkemailwithtemplateawsses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easy2excel.sendbulkemailwithtemplateawsses.service.BulkEmailService;

@RestController
public class BulkEmailController {
	
	@Autowired
	BulkEmailService bulkEmailService;
	
	
	@GetMapping("/sendBulkEmail")
	public String sendBulkEmail() {
		
		bulkEmailService.createTemplate();
	        try {
	        	bulkEmailService.sendBulkEmailAWSSES();
	        } finally {
	        	bulkEmailService.deleteTemplate();
	        }
		return "email sent successfully";
		
		
		
	}

}
