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
            sendEmailService.sendEmail(messageCaptchaRO);
        }
//        boolean insertMessage = messageService.insertMessage(messageCaptchaDTO.getMessage());
//        return insertMessage;
        return true;
    }
    
    @RequestMapping(value = SEND_EMAIL_WITH_FILE_PIECE_URL, method = RequestMethod.POST)
    public String emailSendWithFile(@RequestParam(value = "messageName", required = false) String messageName,
                            @RequestParam(value = "messageEmail", required = false) String messageEmail,
                            @RequestParam(value = "messageText", required = false) String messageText,
                            @RequestParam(value = "messageCaptcha", required = false) String messageCaptcha,
                            final @RequestParam CommonsMultipartFile attachFile) {


        System.out.println(messageName + " - " + messageCaptcha);
        /*SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(mail.getMailFrom());
        message.setTo(mail.getMailTo());
        message.setSubject(mail.getMailSubject());

        Template template = velocityEngine.getTemplate("./templates/" + mail.getTemplateName());

        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("firstName", "Yashwant");
        velocityContext.put("lastName", "Chavan");
        velocityContext.put("location", "Pune");

        StringWriter stringWriter = new StringWriter();

        template.merge(velocityContext, stringWriter);

        message.setText(stringWriter.toString());

        mailSender.send(message);*/



        /*final String emailTo = request.getParameter("mailTo");
        final String subject = request.getParameter("subject");
        final String message = request.getParameter("message");

        // for logging
        System.out.println("emailTo: " + emailTo);
        System.out.println("subject: " + subject);
        System.out.println("message: " + message);
        System.out.println("attachFile: " + attachFile.getOriginalFilename());*/

        /*mailSender.send(new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper messageHelper = new MimeMessageHelper(
                        mimeMessage, true, "UTF-8");
                messageHelper.setTo(emailTo);
                messageHelper.setSubject(subject);
                messageHelper.setText(message);

                // determines if there is an upload file, attach it to the e-mail
                String attachName = attachFile.getOriginalFilename();
                if (!attachFile.equals("")) {

                    messageHelper.addAttachment(attachName, new InputStreamSource() {

                        @Override
                        public InputStream getInputStream() throws IOException {
                            return attachFile.getInputStream();
                        }
                    });
                }

            }

        });*/

        return "Result";
    }

}