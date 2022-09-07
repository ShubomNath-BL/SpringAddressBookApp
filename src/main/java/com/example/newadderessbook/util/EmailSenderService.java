package com.example.newadderessbook.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailsender;

    public void sendEmail(String toEmail, String subject, String body ) {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("shubomnath365@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        mailsender.send(message);
        System.out.println("Mail sent to the User...!");

    }
}
