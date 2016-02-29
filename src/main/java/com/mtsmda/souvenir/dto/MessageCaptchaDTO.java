package com.mtsmda.souvenir.dto;

import com.mtsmda.souvenir.model.Captcha;
import com.mtsmda.souvenir.model.Message;

public class MessageCaptchaDTO {

	private Message message;
	private Captcha captcha;

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Captcha getCaptcha() {
		return captcha;
	}

	public void setCaptcha(Captcha captcha) {
		this.captcha = captcha;
	}

}
