package com.mjk.complaint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjk.complaint.entity.Conversation;
import com.mjk.complaint.repository.ConversationRepository;


@Service
public class ConversationServiceImpl implements ConversationService
{

	@Autowired
	ConversationRepository conversationRepository;
	
	@Override
	public Conversation addConversation(Conversation conversation) {
	
		Conversation savedPost = conversationRepository.save(conversation);
		return savedPost;
	}

		
}
