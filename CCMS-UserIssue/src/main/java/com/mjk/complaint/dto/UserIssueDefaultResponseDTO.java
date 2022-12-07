package com.mjk.complaint.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserIssueDefaultResponseDTO implements MyDTO{

	private String issueDescription;
	private int userId;
	private String category;
	
}
