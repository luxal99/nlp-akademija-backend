package com.example.demo.dto;

import java.util.List;

public class MailDTO {
    private List<String> mailList;
    private String subject;
    private String mailContent;

    public MailDTO() {
    }

    public List<String> getMailList() {
        return mailList;
    }

    public void setMailList(List<String> mailList) {
        this.mailList = mailList;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMailContent() {
        return mailContent;
    }

    public void setMailContent(String mailContent) {
        this.mailContent = mailContent;
    }
}
