package com.chirkovm.service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

/**
 * Created by Michael Chirkov on 01.02.2018.
 */
public interface EmailService {

    public void sendSimpleMessage(String content, String subject) throws MessagingException, UnsupportedEncodingException;
}
