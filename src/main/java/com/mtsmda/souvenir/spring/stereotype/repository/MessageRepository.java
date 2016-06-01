package com.mtsmda.souvenir.spring.stereotype.repository;

import com.mtsmda.souvenir.model.Message;

public interface MessageRepository {
	
	public boolean insertMessage(Message message);
	
}