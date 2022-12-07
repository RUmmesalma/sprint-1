package com.mjk.complaint.util;

import com.mjk.complaint.dto.ConversationCreatedResponseDTO;
import com.mjk.complaint.dto.UserIssueDefaultResponseDTO;
import com.mjk.complaint.entity.Conversation;
import com.mjk.complaint.entity.UserIssue;



public class UserDTOConvertor {
	public static UserIssueDefaultResponseDTO  getUserDefaultDTO(UserIssue userissue)
	{
		UserIssueDefaultResponseDTO dto = new UserIssueDefaultResponseDTO(
				userissue.getIssueDescription(), 
				userissue.getIssueid(), 
				userissue.getCategory());
		return dto;
	}

	public static ConversationCreatedResponseDTO getConversationCreatedDTO(UserIssue userissue,Conversation conversation)
	{
		ConversationCreatedResponseDTO dto = new ConversationCreatedResponseDTO(
				  
				userissue.getUserId(), 
				userissue.getIssueDescription(),
				userissue.getCategory()
				
                 );
				 
				 return dto;
	}
}
