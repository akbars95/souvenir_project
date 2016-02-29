package com.mtsmda.souvenir.repository;

import com.mtsmda.souvenir.model.Message;

public interface MessageRepository {
	
	public boolean insertMessage(Message message);
	
}