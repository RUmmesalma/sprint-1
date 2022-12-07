package com.mjk.complaint.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.mjk.complaint.entity.Conversation;
import com.mjk.complaint.entity.UserIssue;

@Service
public interface UserIssueService {
	public List<UserIssue> getAllUserIssue()throws Exception;
	public UserIssue insertUserIssue(UserIssue userissue)throws Exception;
	public UserIssue getUserIssueByIssueid(int issueid)throws Exception;
	public List<UserIssue> getUserIssueByStatus(boolean status)throws Exception; 
	public List<UserIssue> getUserIssueByCategory(String category)throws Exception;
	public List<UserIssue> getUserIssueByDate(String localDate)throws Exception;
	public List<UserIssue> getUserIssueByTitle(String issueTitle)throws Exception;
	public List<UserIssue> getUserIssuesBetweenIds(int id1,int id2)throws Exception;
	public UserIssue addConversation(Conversation conversation,UserIssue userIssue);

}
