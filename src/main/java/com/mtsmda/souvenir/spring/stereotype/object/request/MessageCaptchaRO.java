package com.mtsmda.souvenir.spring.stereotype.object.request;

import com.mtsmda.souvenir.model.Captcha;
import com.mtsmda.souvenir.model.Message;
import com.mtsmda.souvenir.spring.validation.validators.sequence.FirstSequence;
import com.mtsmda.souvenir.spring.validation.validators.sequence.SecondSequence;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MessageCaptchaRO {

	@NotNull
	@Size(min = 3, max = 50, groups = FirstSequence.class)
	private String messageSendPersonName;

	@NotNull
	@Size(min = 9, max = 50, groups = FirstSequence.class)
	@Email(groups = SecondSequence.class)
	private String messageSendPersonEmail;

	@NotNull
	@Size(min = 9, max = 1000, groups = FirstSequence.class)
	private String messageSendPersonMessage;

	@NotNull
	@Size(min = 2, groups = FirstSequence.class)
	private String captchaPersonWrote;

	@NotNull
	@Size(min = 10, max = 250, groups = FirstSequence.class)
	private String captchaFileName;

	public MessageCaptchaRO() {

	}

	public String getMessageSendPersonName() {
		return messageSendPersonName;
	}

	public void setMessageSendPersonName(String messageSendPersonName) {
		this.messageSendPersonName = messageSendPersonName;
	}

	public String getMessageSendPersonEmail() {
		return messageSendPersonEmail;
	}

	public void setMessageSendPersonEmail(String messageSendPersonEmail) {
		this.messageSendPersonEmail = messageSendPersonEmail;
	}

	public String getMessageSendPersonMessage() {
		return messageSendPersonMessage;
	}

	public void setMessageSendPersonMessage(String messageSendPersonMessage) {
		this.messageSendPersonMessage = messageSendPersonMessage;
	}

	public String getCaptchaPersonWrote() {
		return captchaPersonWrote;
	}

	public void setCaptchaPersonWrote(String captchaPersonWrote) {
		this.captchaPersonWrote = captchaPersonWrote;
	}

	public String getCaptchaFileName() {
		return captchaFileName;
	}

	public void setCaptchaFileName(String captchaFileName) {
		this.captchaFileName = captchaFileName;
	}

	public Message getMessage(){
		return new Message(this.messageSendPersonName, this.messageSendPersonEmail, this.messageSendPersonMessage, null);
	}

	public Captcha getCaptcha(){
		return new Captcha(this.captchaPersonWrote, this.captchaFileName);
	}
}
