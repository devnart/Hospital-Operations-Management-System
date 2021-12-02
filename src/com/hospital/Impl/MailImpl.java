package com.hospital.Impl;
import com.hospital.interfaces.MailInterface;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
public class MailImpl implements MailInterface {


    public void sendMail(String to, String subject, String body) {

        final String username = "hr.fb001@gmail.com";
        final String password = "zavucelhbryyyqgu";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(to)
            );
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

            System.out.println("Done - Email sent successfully");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public String generateString(List operations) {

        StringBuilder sb = new StringBuilder();
        for (Object o : operations) {
            sb.append(o.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

}
