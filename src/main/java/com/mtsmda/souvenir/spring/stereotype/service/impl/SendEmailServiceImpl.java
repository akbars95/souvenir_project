package com.mtsmda.souvenir.spring.stereotype.service.impl;

import com.mtsmda.souvenir.model.Captcha;
import com.mtsmda.souvenir.model.Message;
import com.mtsmda.souvenir.spring.stereotype.object.request.MessageCaptchaRO;
import com.mtsmda.souvenir.spring.stereotype.service.CaptchaService;
import com.mtsmda.souvenir.spring.stereotype.service.MessageService;
import com.mtsmda.souvenir.spring.stereotype.service.SendEmailService;
import com.mtsmda.souvenir.spring.validation.structural.StructuralValidation;
import com.mtsmda.souvenir.spring.validation.structural.StructuralValidationResult;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.StringWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by dminzat on 6/27/2016.
 */
@Service("sendEmailService")
public class SendEmailServiceImpl implements SendEmailService {

    @Autowired
    @Qualifier("structuralValidationImpl")
    private StructuralValidation structuralValidation;

    @Autowired
    @Qualifier("captchaService")
    private CaptchaService captchaService;

    @Autowired
    @Qualifier("messageService")
    private MessageService messageService;

    @Autowired
    @Qualifier("mailSender")
    private JavaMailSenderImpl mailSender;

    @Autowired
    @Qualifier("velocityEngine")
    private VelocityEngine velocityEngine;

    @Override
    public boolean sendEmail(MessageCaptchaRO messageCaptchaRO) {
        StructuralValidationResult validate = structuralValidation.validate(messageCaptchaRO);
        if (validate.isSuccess()) {
            Captcha captcha = messageCaptchaRO.getCaptcha();
            Captcha captchaFromDB = captchaService.checkCaptcha(captcha);
            if (captchaFromDB != null) {
                Message message = messageCaptchaRO.getMessage();
                message.setMessageCaptchaId(captchaFromDB.getCaptchaId());
                if (messageService.insertMessage(message)) {
                    return sendEmail(message);
                }
            }
        }
        return false;
    }

    private boolean sendEmail(Message message) {
        this.mailSender.getJavaMailProperties().put("mail.smtp.host", "smtp.gmail.com");
        this.mailSender.getJavaMailProperties().put("mail.smtp.port", "587");
        Session session = Session.getInstance(this.mailSender.getJavaMailProperties(), new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("souvenir.buy.site@gmail.com",
                        "souvenir.buy.site9");
            }
        });

        /*javax.mail.Message*/
        MimeMessage messageMail = new MimeMessage(session);
/*
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("souvenir.buy.site@gmail.com");
        simpleMailMessage.setTo("souvenir.buy.site@gmail.com");
        simpleMailMessage.setSubject(message.getMessageName());*/

        Template template = velocityEngine.getTemplate("./velocity.template/email_template.vm");//


        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("emailWriter", message.getMessageName());
        velocityContext.put("emailWriterText", message.getMessageText());
        velocityContext.put("emailWriterEmailAddress", message.getMessageEmail());
        velocityContext.put("serverDateTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));

        StringWriter stringWriter = new StringWriter();
        template.merge(velocityContext, stringWriter);
        message.setMessageText(stringWriter.toString());

        try {
            messageMail.setFrom(new InternetAddress("souvenir.buy.site@gmail.com"));
            messageMail.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress("souvenir.buy.site@gmail.com"));
            messageMail.setSubject("Subject - email from site");
            messageMail.setText(stringWriter.toString(), "UTF-8", "html");

//            mailSender.send(simpleMailMessage);
//            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(messageMail);
            Transport.send(messageMail);
        } catch (MailException | MessagingException e) {
            //https://www.google.com/settings/security/lesssecureapps - fix
            return false;
        }
        return true;
    }

}
