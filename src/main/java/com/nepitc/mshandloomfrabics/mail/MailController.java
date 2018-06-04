/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.mail;

import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Nishan Dhungana
 */
@Controller
public class MailController {

    private final String emailSubject = "Recover Password";
    private final String emailFromRecipient = "nishandhungana41@gmail.com";

    @Autowired
    private JavaMailSender mailSenderObj;

    @RequestMapping(value = "/send-mail", method = RequestMethod.POST)
    public ResponseEntity<String> sendEmailToClient(@RequestParam("email") final String receiverEmail) {
        final StringBuilder message = new StringBuilder();
        message.append("<p>Please click <a href=\"https://www.youtube.com/watch?v=yKNxeF4KMsY\">here</a> to recover password</p>");

        try {
            mailSenderObj.send(new MimeMessagePreparator() {
                @Override
                public void prepare(MimeMessage mimeMessage) throws Exception {
                    MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                    mimeMsgHelperObj.setTo(receiverEmail);
                    mimeMsgHelperObj.setFrom(emailFromRecipient);
                    mimeMsgHelperObj.setText(message.toString(), true);
                    mimeMsgHelperObj.setSubject(emailSubject);
                }
            });

            return new ResponseEntity<>("Email sent", HttpStatus.OK);
        } catch (MailException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
