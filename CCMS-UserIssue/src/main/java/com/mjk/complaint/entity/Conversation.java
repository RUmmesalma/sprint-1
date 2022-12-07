package com.mjk.complaint.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conversation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid; // discuss with ishita (regarding variable name ,should be same)
    private int conversationId;
    private int conissueid;
	private String title;
    private String description;
    private String userName;
    private String postingDate;
	public Conversation(int conissueid,String title, String description, String userName, String postingDate) {
		super();
		this.conissueid=conissueid;
		this.title = title;
		this.description = description;
		this.userName = userName;
		this.postingDate = postingDate;
	}
    
    
}
