package com.mjk.complaint.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.mjk.complaint.entity.UserIssue;

@Repository
public interface UserIssueRepository extends JpaRepository<UserIssue, Integer> , UserIssueCustomRepository 
{

}
