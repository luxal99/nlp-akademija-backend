package com.example.demo.service;

import com.example.demo.dto.MailDTO;
import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepository;
import javassist.bytecode.analysis.Executor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.*;
import java.util.regex.Pattern;

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
    public String sendMail(MailDTO mailDTO) throws MessagingException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        int partNum = mailDTO.getMailList().size() / 10;
        MailServiceImpl mailService;
        MailServiceImpl mailService1;
        MailServiceImpl mailService2;
        MailServiceImpl mailServic3;
        MailServiceImpl mailService4;
        MailServiceImpl mailService5;
        MailServiceImpl mailServic6;
        MailServiceImpl mailService7;
        MailServiceImpl mailService8;
        MailServiceImpl mailService9;
        MailServiceImpl mailService10;




        Thread[] arrThred = {
                mailService = new MailServiceImpl(mailDTO, 0, partNum),
                mailService1 = new MailServiceImpl(mailDTO, partNum, 2 * partNum),
                mailService2 = new MailServiceImpl(mailDTO, 2 * partNum, 3 * partNum),

                mailServic3 = new MailServiceImpl(mailDTO, 3 * partNum, 4 * partNum),
                mailService4 = new MailServiceImpl(mailDTO, 4 * partNum, 5 * partNum),
                mailService5 = new MailServiceImpl(mailDTO, 5 * partNum, 6 * partNum),

                mailServic6 = new MailServiceImpl(mailDTO, 6 * partNum, 7 * partNum),
                mailService7 = new MailServiceImpl(mailDTO, 7 * partNum, 8 * partNum),
                mailService8 = new MailServiceImpl(mailDTO, 8 * partNum, 9 * partNum),

                mailService9 = new MailServiceImpl(mailDTO, 9 * partNum, 10 * partNum),
                mailService10 = new MailServiceImpl(mailDTO, 10 * partNum, mailDTO.getMailList().size())
        };

        for (int i = 0; i < arrThred.length; i++) {
            System.out.println("Threar: "+i);
            if (i == 5) {
                arrThred[i].start();
                Thread.sleep(45000);
            }else if(i==9){
                arrThred[i].start();
                Thread.sleep(10000);
            }
            else {
                arrThred[i].start();
            }
        }

        return "Email sent!";
    }


}



