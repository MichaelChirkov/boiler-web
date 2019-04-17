package com.chirkovm.service.impl;

import com.chirkovm.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * Created by Michael Chirkov on 01.02.2018.
 */
@Service
@EnableAsync
public class EmailServiceImpl implements EmailService {

    @Autowired
    Environment env;

    @Async
    public void sendSimpleMessage(String content,
                                         String subject)
            throws MessagingException, UnsupportedEncodingException {

        Properties props = System.getProperties();

            props.put("mail.smtp.port", env.getProperty("mail.smtp.port"));
            props.put("mail.smtp.host", env.getProperty("mail.smtp.host"));
            props.put("mail.smtp.starttls.enable", env.getProperty("mail.smtp.starttls.enable"));
            props.put("mail.smtp.socketFactory.port", env.getProperty("mail.smtp.socketFactory.port") );
            props.put("mail.smtp.socketFactory.class", env.getProperty("mail.smtp.socketFactory.class"));
            props.put("mail.smtp.auth", env.getProperty("mail.smtp.auth"));
            props.put("mail.debug", env.getProperty("mail.debug"));
            props.put("mail.mime.charset", env.getProperty("mail.mime.charset"));

            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(env.getProperty("mail.login"), env.getProperty("mail.password"));
                        }
                    });

            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(env.getProperty("mail.from")));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(env.getProperty("mail.to")));
            msg.setSubject(subject);
            msg.setText(content);
            Transport.send(msg);
        }
}
