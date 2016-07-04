package com.mtsmda.souvenir.spring.stereotype.controller.restController;

import com.mtsmda.souvenir.spring.stereotype.controller.constants.StaticPageConstants;
import com.mtsmda.souvenir.spring.stereotype.controller.restController.constants.EmailSenderRestControllerConstants;
import com.mtsmda.souvenir.spring.stereotype.service.SendEmailService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import com.mtsmda.souvenir.spring.stereotype.object.request.MessageCaptchaRO;
import com.mtsmda.souvenir.spring.stereotype.service.MessageService;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@RestController
@RequestMapping(value = StaticPageConstants.REST_PATH_URL)
public class EmailSenderRestController implements EmailSenderRestControllerConstants{

    private Logger logger = Logger.getLogger(getClass());

    /*@Autowired
    @Qualifier("mailSender")
    private JavaMailSender mailSender;*/

    @Autowired
    @Qualifier("messageService")
    private MessageService messageService;

    @Autowired
    @Qualifier("sendEmailService")
    private SendEmailService sendEmailService;

    /*@Autowired
    @Qualifier("velocityEngine")
    private VelocityEngine velocityEngine;*/

    @RequestMapping(value = SEND_EMAIL_PIECE_URL, method = RequestMethod.POST)
    public boolean emailSend(@RequestBody MessageCaptchaRO messageCaptchaRO ) {
        logger.info("new message - " + messageCaptchaRO.toString());
        if(messageCaptchaRO != null){
            return sendEmailService.sendEmail(messageCaptchaRO);
        }
        return false;
    }
    
    @RequestMapping(value = SEND_EMAIL_WITH_FILE_PIECE_URL, method = RequestMethod.POST)
    public String emailSendWithFile(@RequestParam(value = "messageName", required = false) String messageName,
                            @RequestParam(value = "messageEmail", required = false) String messageEmail,
                            @RequestParam(value = "messageText", required = false) String messageText,
                            @RequestParam(value = "messageCaptcha", required = false) String messageCaptcha,
                            final @RequestParam CommonsMultipartFile attachFile) {
        return null;
    }

}