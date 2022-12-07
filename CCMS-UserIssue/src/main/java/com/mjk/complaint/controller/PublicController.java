package com.mjk.complaint.controller;

import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mjk.complaint.dto.UserIssueDefaultResponseDTO;
import com.mjk.complaint.entity.Conversation;
import com.mjk.complaint.entity.UserIssue;
import com.mjk.complaint.service.ConversationService;
import com.mjk.complaint.service.UserIssueService;
import com.mjk.complaint.dto.ConversationCreatedResponseDTO;
import com.mjk.complaint.dto.ErrorDTO;
import com.mjk.complaint.dto.MyDTO;
import com.mjk.complaint.dto.UserIssueDefaultResponseDTO;
import com.mjk.complaint.util.UserDTOConvertor;


@RestController
@RequestMapping("/public/userissue")
public class PublicController {
	@Autowired
	UserIssueService userIssueService;
	@Autowired
	ConversationService conversationService;
	public PublicController() {
		System.out.println("\n\n\n====>> Inside Constructor "+this);
	}
	@GetMapping("/users")
	public List<UserIssue> getAllUserIssues()
	{
		// write some code to extract users
		try {
			List<UserIssue>  allExtractedUsers = userIssueService.getAllUserIssue();
			
			return allExtractedUsers;
			
		} catch (Exception e) {
			// code missing for expection handling 
			System.out.println(e);
			
		}
		
		return null;
	}
	@GetMapping("/user/id/{id}")
	public ResponseEntity<MyDTO> getUserByUserId(@PathVariable int id)throws Exception
	{
		
			UserIssue issue = userIssueService.getUserIssueByIssueid(id);
			
			UserIssueDefaultResponseDTO dtoResp = UserDTOConvertor.getUserDefaultDTO(issue);
			
			return new ResponseEntity<MyDTO>(dtoResp, HttpStatus.OK);
		
	}
	@GetMapping("/status/{status}")
	public List<UserIssue> userIssuesByStatus(@PathVariable boolean status)throws Exception
	{
		return userIssueService.getUserIssueByStatus(status);
	}
	@GetMapping("/category/{searchCategory}")
	public List<UserIssue> userIssuesByCategory(@PathVariable String searchCategory)throws Exception
	{
		return userIssueService.getUserIssueByCategory(searchCategory);
	}
	@GetMapping("/localDate/{searchDate}")
	public List<UserIssue> userIssuesByDate(@PathVariable String searchDate)throws Exception
	{
		return userIssueService.getUserIssueByCategory(searchDate);
	}
	@GetMapping("/title/{title}")
	public List<UserIssue> userIssuesByTitle(@PathVariable String title)throws Exception
	{
		return userIssueService.getUserIssueByTitle(title);
	}
	@GetMapping("/betweenIds")
	public List<UserIssue> userIssuesByIds(@RequestParam int id1,@RequestParam int id2)throws Exception
	{
		return userIssueService.getUserIssuesBetweenIds(id1, id2);
	}
	@PostMapping("/issueid/{issueid}/conversation/{description}")
	public ResponseEntity<MyDTO> addConversation(@PathVariable int issueid,@PathVariable String description)
	{
		
		UserIssue savedUserIssue  = null; 
		try {
			savedUserIssue = userIssueService.getUserIssueByIssueid(issueid);
			if(savedUserIssue != null)
			{
				Conversation conversation = new Conversation(1,"screen",description,"A",LocalDate.now().toString());
				Conversation savedConversation = conversationService.addConversation(conversation);
				
				if(savedConversation.getConversationId() != 0)
				{
					// code to link post with user
					UserIssue updatedUserIssueWithCon = userIssueService.addConversation(savedConversation, savedUserIssue);
					
					ConversationCreatedResponseDTO dto = UserDTOConvertor.getConversationCreatedDTO(updatedUserIssueWithCon,conversation);
					
					return new ResponseEntity<MyDTO>(dto, HttpStatus.OK);
				}
				
			}
			else
			{
				throw new Exception("User not found "+savedUserIssue+" for "+issueid);
			}
			
		} catch (Exception e) {
			System.out.println(savedUserIssue+" is not");
			
			ErrorDTO errorDto = new ErrorDTO(e.getMessage());
			return new ResponseEntity<MyDTO>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		
		
		return null;
		
	}

	
}
