package com.example.demo.service;

import com.example.demo.dto.MailDTO;
import com.example.demo.entity.Admin;

import javax.mail.MessagingException;

public interface AdminService{
    public String sendMail(MailDTO mailDTO) throws MessagingException, InterruptedException;
}
