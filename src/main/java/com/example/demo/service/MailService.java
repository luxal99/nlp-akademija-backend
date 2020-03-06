package com.example.demo.service;

import com.example.demo.dto.MailDTO;

import javax.mail.MessagingException;

public interface MailService  {
    public String sendMail(MailDTO mailDTO,int from,int to) throws MessagingException;
}
