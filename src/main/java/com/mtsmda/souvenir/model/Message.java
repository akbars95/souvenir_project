package com.mtsmda.souvenir.model;

import java.io.Serializable;

import com.mtsmda.souvenir.annotation.ModelClassInfo;

@ModelClassInfo(tableName = "MESSAGE")
public class Message implements Serializable {

	private Integer messageId;
	private String messageName;
	private String messageEmail;
	private String messageText;
	private Integer messageCaptchaId;

	public Message() {

	}

	public Message(String messageName, String messageEmail, String messageText, Integer messageCaptchaId) {
		setMessageName(messageName);
		setMessageEmail(messageEmail);
		setMessageText(messageText);
		setMessageCaptchaId(messageCaptchaId);
	}

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public String getMessageName() {
		return messageName;
	}

	public void setMessageName(String messageName) {
		this.messageName = messageName;
	}

	public String getMessageEmail() {
		return messageEmail;
	}

	public void setMessageEmail(String messageEmail) {
		this.messageEmail = messageEmail;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public Integer getMessageCaptchaId() {
		return messageCaptchaId;
	}

	public void setMessageCaptchaId(Integer messageCaptchaId) {
		this.messageCaptchaId = messageCaptchaId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((messageCaptchaId == null) ? 0 : messageCaptchaId.hashCode());
		result = prime * result + ((messageEmail == null) ? 0 : messageEmail.hashCode());
		result = prime * result + ((messageName == null) ? 0 : messageName.hashCode());
		result = prime * result + ((messageText == null) ? 0 : messageText.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (messageCaptchaId == null) {
			if (other.messageCaptchaId != null)
				return false;
		} else if (!messageCaptchaId.equals(other.messageCaptchaId))
			return false;
		if (messageEmail == null) {
			if (other.messageEmail != null)
				return false;
		} else if (!messageEmail.equals(other.messageEmail))
			return false;
		if (messageName == null) {
			if (other.messageName != null)
				return false;
		} else if (!messageName.equals(other.messageName))
			return false;
		if (messageText == null) {
			if (other.messageText != null)
				return false;
		} else if (!messageText.equals(other.messageText))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", messageName=" + messageName + ", messageEmail=" + messageEmail
				+ ", messageText=" + messageText + ", messageCaptcha=" + messageCaptchaId + "]";
	}

}