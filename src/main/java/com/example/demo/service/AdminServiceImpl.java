package com.example.demo.service;

import com.example.demo.dto.MailDTO;
import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public boolean isValidDate(Admin admin) {
        return false;
    }

    @Override
    public String changePassword(String password) {
        return null;
    }

    @Override
    public Boolean isLogged() {
        long id = 1;
        Admin admin = adminRepository.findById(id).get();
        return admin.isLogged();
    }

    @Override
    public Admin getAdmin() {
        long id = 1;
        Admin admin = adminRepository.findById(id).get();
        return admin;
    }

    @Override
    public Admin putFlag(Admin admin) {
        adminRepository.save(admin);
        return admin;
    }

    @Override
    public boolean isValid(String username, String password) {
        List<Admin> loginList = adminRepository.findAll();
        boolean isValid = false;
        for (Admin login : loginList) {
            if (login.getUsername().equals(username) && login.getPassword().equals(password)) {
                isValid = true;
            } else {
                isValid = false;
            }
        }
        return isValid;
    }

    @Override
    public String sendMail(MailDTO mailDTO) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("nlpmasterakademija@gmail.com", "Preparantus");
            }
        });

        for (int i = 0; i < mailDTO.getMailList().size(); i++) {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(mailDTO.getMailList().get(i), false));

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailDTO.getMailList().get(i)));
            msg.setSubject(mailDTO.getSubject());
            msg.setContent(mailDTO.getMailContent(), "text/html");
            msg.setSentDate(new Date());

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent("Tutorials point email", "text/html");

            Transport.send(msg);


        }
        return "Email sent!";

    }
}



