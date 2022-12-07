package com.mjk.complaint.service;

import org.springframework.stereotype.Service;

import com.mjk.complaint.entity.Conversation;

@Service
public interface ConversationService {

	public Conversation addConversation(Conversation conversation);
}