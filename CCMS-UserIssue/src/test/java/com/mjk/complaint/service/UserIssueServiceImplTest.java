package com.mjk.complaint.service;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.mjk.complaint.entity.UserIssue;
import com.mjk.complaint.repository.UserIssueRepository;
@SpringBootTest
class UserIssueServiceImplTest {
	@Mock
	UserIssueRepository userIssueRepository;
	
	@InjectMocks
   UserIssueServiceImplementation userIssueService;
	@Test
	@DisplayName("Test - to verify the insert operation")
	//@Disabled
	void testInsertUserIssue() throws Exception {
		// given
		UserIssue sampleInput = new UserIssue(1,"mobile issue","screen lagging", "mobile","11-11-2019","11:40",true);
		UserIssue expectedOutput = new UserIssue(2,"mobile issue","screen lagging", "mobile","11-11-2019","11:40",true);
		//Object obj = new Object();
		BDDMockito.given(userIssueService.insertUserIssue(sampleInput)).willReturn(expectedOutput);
		
		// when 
		UserIssue actualOutput = userIssueService.insertUserIssue(sampleInput);
		
		// verify 
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	@Disabled
	void testGetFileLogs() {
		fail("Not yet implemented");
	}

	@Test
	//@Disabled
	@DisplayName("Test to verify the method getUserIssue By Issueid should return UserIssue or not")
	void testGetUserIssueByIssueid() throws Exception 
	{
		
		// give 
		UserIssue sampleOutput = new UserIssue(2,"mobile issue","screen lagging", "mobile","11-11-2019","11:40",true);
		sampleOutput.setIssueid(1);
		
		int sampleInput = 1;
		
		BDDMockito.given(userIssueService.getUserIssueByIssueid(sampleInput)).willReturn(sampleOutput);
		
		// when 
		UserIssue actualOutput = userIssueService.getUserIssueByIssueid(sampleInput);
		
		// verify
		assertEquals(sampleOutput,actualOutput);
		assertSame(sampleOutput.getIssueid(), actualOutput.getIssueid());
		assertThat(actualOutput.getIssueid()).isGreaterThan(0);
		
	}
		
	
	@Test
	@DisplayName("Test to verify all user returend")
	//@Disabled
	void testGetAllUserIssues() throws Exception {
	
		// given
		
		UserIssue userIssue1 = new UserIssue(1,"mobile issue","screen lagging", "mobile","11-11-2019","11:40",true);
		userIssue1.setFileLogs(null);
		
		UserIssue userIssue2 = new UserIssue(2,"mobile issue","screen lagging", "mobile","11-11-2019","11:40",true);
		userIssue2.setFileLogs(null);
		
		
		List<UserIssue> sampleOutput = new ArrayList<>();
		sampleOutput.add(userIssue1);
		sampleOutput.add(userIssue2);
		
		BDDMockito.given(userIssueService.getAllUserIssue()).willReturn(sampleOutput);
		
		// ----------------------------------------------------------------------
		
		// when :- readyto test the funcationality (service)
		List<UserIssue> actualOutput = userIssueService.getAllUserIssue();
		
		
		// then : verify the sampleOutput with actual output
		// assertThat(actualOutput).isNotNull();  // or
		assertNotNull(actualOutput);
		assertThat(actualOutput.size()).isGreaterThan(0);
		assertIterableEquals(sampleOutput, actualOutput);
		
	}
	


}
