package com.example.demo.service;

import com.example.demo.dto.MailDTO;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MailServiceImpl extends Thread implements MailService {
    private MailDTO mailDTO;
    private Integer from;
    private Integer to;

    public MailDTO getMailDTO() {
        return mailDTO;
    }

    public void setMailDTO(MailDTO mailDTO) {
        this.mailDTO = mailDTO;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public MailServiceImpl(MailDTO mailDTO, Integer from, Integer to) {
        this.mailDTO = mailDTO;
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
        try {
            sendMail(this.mailDTO,this.from,this.to);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String sendMail(MailDTO mailDTO,int from,int to) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.sendpartial", "true");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("nlpmasterakademija@gmail.com", "Preparantus");
            }
        });
        int validMail = 0;
        for (int i = from; i < to; i++) {
            if (isValidEmailAddress(mailDTO.getMailList().get(i))) {
                validMail++;
                Message msg = new MimeMessage(session);
                try {
                    msg.setFrom(new InternetAddress(mailDTO.getMailList().get(i), false));
                    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailDTO.getMailList().get(i)));
                    msg.setSubject(mailDTO.getSubject());
                    msg.setContent(mailDTO.getMailContent(), "text/html");
                    msg.setSentDate(new Date());

                    MimeBodyPart messageBodyPart = new MimeBodyPart();
                    messageBodyPart.setContent("Tutorials point email", "text/html");

                    Transport.send(msg);


                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(validMail);

        }

        return null;
    }
    public static boolean isValidEmailAddress(String email) throws AddressException {
        boolean isValid = false;

        InternetAddress internetAddress = new InternetAddress(email);
        internetAddress.validate();
        isValid = true;
        if (email.contains("gmail.com")) {
            isValid = true;
        } else {
            isValid = false;
        }

        return isValid;
    }
}
