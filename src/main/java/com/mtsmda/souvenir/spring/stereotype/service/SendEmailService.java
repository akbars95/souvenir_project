package com.mtsmda.souvenir.spring.stereotype.service;

import com.mtsmda.souvenir.spring.stereotype.object.request.MessageCaptchaRO;

/**
 * Created by dminzat on 6/27/2016.
 */
public interface SendEmailService {

    public boolean sendEmail(MessageCaptchaRO messageCaptchaRO);

}