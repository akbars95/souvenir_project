package com.mtsmda.souvenir.spring.stereotype.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mtsmda.souvenir.model.Message;
import com.mtsmda.souvenir.spring.stereotype.repository.MessageRepository;
import com.mtsmda.souvenir.spring.stereotype.service.MessageService;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

	@Autowired
	@Qualifier("messageRepository")
	private MessageRepository messageRepository;

	@Override
	public boolean insertMessage(Message message) {
		return messageRepository.insertMessage(message);
	}

}