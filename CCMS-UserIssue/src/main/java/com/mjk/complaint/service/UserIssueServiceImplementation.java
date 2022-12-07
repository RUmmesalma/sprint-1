package com.mjk.complaint.service;

import java.util.ArrayList;


import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjk.complaint.entity.Conversation;
import com.mjk.complaint.entity.UserIssue;
import com.mjk.complaint.repository.UserIssueRepository;



@Service
public class UserIssueServiceImplementation implements UserIssueService{
	@Autowired
	UserIssueRepository userIssueRepository;
	
	@Override
	@Transactional
	public UserIssue insertUserIssue(UserIssue user) throws Exception {
		UserIssue savedUserIssue	 =  userIssueRepository.save(user);  // Note :  save() is already implemented by Spring Data JPA
		if(savedUserIssue != null)
		{
			return savedUserIssue;
		}
		else return null;
        }

	@Override
	@Transactional
	public UserIssue addConversation(Conversation conversation, UserIssue userIssue) {
		
		List<Conversation> con = userIssue.getFileLogs();
		
		if(con == null)
		{
			con = new ArrayList<>();
			con.add(conversation);
		}
		else
		{
			con.add(conversation);
		}
		
		userIssue.setFileLogs(con);
		
		
		return userIssue;
	}


	@Override
	public List<UserIssue> getAllUserIssue() throws Exception {
			
		List<UserIssue> allUserIssues =  userIssueRepository.findAll(); // Note : same as save
				return allUserIssues;
	}

	@Override
	public UserIssue getUserIssueByIssueid(int issueid) throws Exception {
		UserIssue outputUser=userIssueRepository.getUserIssueByIssueid(issueid);
		return outputUser;
		
	}
	@Override
	public List<UserIssue> getUserIssueByStatus(boolean searchstatus)throws Exception{
	List<UserIssue> outputIssues=getAllUserIssue().stream().filter((iss)->iss.getStatus()==searchstatus).collect(Collectors.toList());
	return outputIssues;
	}
	@Override
	public List<UserIssue> getUserIssueByCategory(String category)throws Exception{
	List<UserIssue> outputIssues=getAllUserIssue().stream().filter((iss)->iss.getCategory().equals(category)).collect(Collectors.toList());
	return outputIssues;
	}
	@Override
	public List<UserIssue> getUserIssueByDate(String localDate)throws Exception{
		List<UserIssue> outputIssues=getAllUserIssue().stream().filter((iss)->iss.getLocalDate().equals(localDate)).collect(Collectors.toList());
	return outputIssues;
	}
	
	@Override
	public List<UserIssue> getUserIssueByTitle(String issueTitle)throws Exception{
		List<UserIssue> outputIssues=getAllUserIssue().stream().filter((iss)->iss.getIssueTitle().equals(issueTitle)).collect(Collectors.toList());
	return outputIssues;
	}
	@Override
	public List<UserIssue> getUserIssuesBetweenIds(int id1,int id2)throws Exception{
		List<UserIssue> outputIssues=getAllUserIssue().stream().filter((iss)->iss.getIssueid()>=id1 && iss.getIssueid()<=id2).collect(Collectors.toList());
		return outputIssues;
		}
	

}
