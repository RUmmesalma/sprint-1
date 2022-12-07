package com.mjk.complaint.dto;

import org.springframework.stereotype.Component;


import com.mjk.complaint.dto.MyDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ConversationCreatedResponseDTO implements MyDTO{

	private int issueid;;
	private String description;
	private String category;
}