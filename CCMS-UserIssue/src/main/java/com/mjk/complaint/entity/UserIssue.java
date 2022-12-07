package com.mjk.complaint.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "userissue")
public class UserIssue {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int issueid;
	
	@PositiveOrZero(message = "Invalid Issue Id")
    private int userId;
	
	@NotNull(message = "Title cannot be Null")
	@Size(min = 4,message = "Title is not valid,should have more than 4 characters")
	private String issueTitle;
	
	@Size(min = 10,max=100,message = "Description must be between 10 and 100 characters")
    private String issueDescription;
	
	@NotNull(message = "Category cannot be Null")
	private String category;
	private String localDate;
	private String time;
	
	private boolean status;
	

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="conversation")
	private List<Conversation> fileLogs;

	public UserIssue(int userId, String issueTitle, String issueDescription, String category, String localDate,
			String time, boolean status) {
		super();
		this.userId = userId;
		this.issueTitle = issueTitle;
		this.issueDescription = issueDescription;
		this.category = category;
		this.localDate = localDate;
		this.time = time;
		this.status = status;
	}


	public boolean getStatus() {
		return status;
		
	}
	public void setStatus(boolean status) {
		this.status=status;
	}

}
