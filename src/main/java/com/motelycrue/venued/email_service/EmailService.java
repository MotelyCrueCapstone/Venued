package com.motelycrue.venued.email_service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class EmailService {



    @Autowired
    public JavaMailSender emailSender;

    @Value("${spring.mail.from}")
    private String from;

    public void prepareAndSend(String subject, String message, String email) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(email);
        mailMessage.setTo();
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        try {
            this.emailSender.send(mailMessage);
        } catch (MailException e) {
            // runtime exception; compiler will not force you to handle it
        }
    }
}
