package com.mjk.complaint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjk.complaint.entity.UserIssue;
import com.mjk.complaint.service.UserIssueService;

@RestController//to mark it as a request handler
@RequestMapping("/client/userissue")//to map web requests to spring controller methods
public class ClientWebController {

	@Autowired//injecting dependency
	UserIssueService userIssueService;
	public ClientWebController() {
		System.out.println("\n\n\n====>> Inside Constructor "+this);
	}
	@PostMapping("/add")
	public ResponseEntity<String> addUserIssue(@RequestBody UserIssue user) 
	{
		/*
		 * // request body annotation  , help u 
		 * to take user information as JSON , so it convert JSON object to AppIser Object
		 * */
		try {
			UserIssue savedUserIssue =  userIssueService.insertUserIssue(user);
			String responseMsg = savedUserIssue.getIssueTitle()+" save with Id "+savedUserIssue.getIssueid();
			return new ResponseEntity<String>(responseMsg,HttpStatus.OK);
		} catch (Exception e) {
			String errorMsg =  "Contact to customer care 1800-250-960 or mail us :- customercomplaintmanagementsystem.com";
			return new ResponseEntity<String>(errorMsg,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{issueid}")
	public UserIssue update(@PathVariable int issueid,@RequestBody UserIssue userissue )throws Exception{
		UserIssue output=userIssueService.getUserIssueByIssueid(issueid);
		userissue.setIssueid(issueid);
		UserIssue updatedUserIssue=userIssueService.insertUserIssue(userissue);
		return updatedUserIssue;
	}
	
	
}