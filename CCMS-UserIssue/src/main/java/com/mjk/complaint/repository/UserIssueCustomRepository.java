package com.mjk.complaint.repository;

import java.util.List;

import com.mjk.complaint.entity.UserIssue;

public interface UserIssueCustomRepository {
	public UserIssue getUserIssueByIssueid(int issueid)throws Exception;
    

}
