package com.example.service;

import com.example.entity.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.UnsupportedEncodingException;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Value("${spring.mail.username}")
    private String sender;
    @Value("${spring.mail.username}")
    private String receiver;

    public String sendEmail() {
        try {

            // Creating a simple mail message
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            // Setting up necessary details
            helper.setFrom(new InternetAddress(sender, "Ashish Nanaware"));
            helper.setTo(receiver);
            helper.setText("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <title>Email Template</title>\n" +
                    "    <style>\n" +
                    "        body {\n" +
                    "            font-family: Arial, sans-serif;\n" +
                    "            margin: 0;\n" +
                    "            padding: 0;\n" +
                    "            background-color: #f4f4f4;\n" +
                    "        }\n" +
                    "\n" +
                    "        .container {\n" +
                    "            max-width: 600px;\n" +
                    "            margin: 0 auto;\n" +
                    "            padding: 20px;\n" +
                    "            background-color: #ffffff;\n" +
                    "            box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);\n" +
                    "        }\n" +
                    "\n" +
                    "        .header {\n" +
                    "            background-color: #007bff;\n" +
                    "            color: #ffffff;\n" +
                    "            text-align: center;\n" +
                    "            padding: 2px 0;\n" +
                    "        }\n" +
                    "\n" +
                    "        .content {\n" +
                    "            padding: 20px;\n" +
                    "        }\n" +
                    "\n" +
                    "        .footer {\n" +
                    "            background-color: #f8f9fa;\n" +
                    "            text-align: center;\n" +
                    "            padding: 10px 0;\n" +
                    "        }\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    "\n" +
                    "<body>\n" +
                    "    <div class=\"container\">\n" +
                    "        <div class=\"header\">\n" +
                    "            <h1>Email Template</h1>\n" +
                    "        </div >\n" +
                    "        <div class=\"content\">\n" +
                    "            <p>Hello "+receiver+",</p>\n" +
                    "            <p>This is a custom email template. You can customize the content and styles as per your requirements.</p>\n" +
                    "            <p>Best regards,</p>\n" +
                    "            <p>Your Name</p>\n" +
                    "        </div>\n" +
                    "        <div class=\"footer\">\n" +
                    "            <p>© 2023 Your Company. All rights reserved.</p>\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "</body>\n" +
                    "\n" +
                    "</html>\n", true);
            helper.setSubject("Test email");

            // Sending the mail
            javaMailSender.send(message);

        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return "Email send sucessfully";
    }



    // Method 1
    // To send a simple email
    public String sendSimpleMail(EmailDetails details)
    {
        // Try block to check for exceptions
        try {
            // Creating a simple mail message
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            // Setting up necessary details
            helper.setFrom(new InternetAddress(sender, "Ashish Nanaware"));
            helper.setTo(details.getRecipient());
            helper.setText(details.getMsgBody(),true);
            helper.setSubject(details.getSubject());

            // Sending the mail
            javaMailSender.send(message);
            return "Email sent successfully";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Sending email failed";
        }
    }

    // Method 2
    // To send an email with attachment
    public String
    sendMailWithAttachment(EmailDetails details)
    {
        // Creating a mime message
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {

            // Setting multipart as true for attachments to
            // be send
            mimeMessageHelper
                    = new MimeMessageHelper(mimeMessage, true);
            try {
                mimeMessageHelper.setFrom(new InternetAddress(sender, "Ashish Nanaware"));
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setText(details.getMsgBody(),true);
            mimeMessageHelper.setSubject(
                    details.getSubject());

            // Adding the attachment
            FileSystemResource file
                    = new FileSystemResource(
                    new File(details.getAttachment()));

            mimeMessageHelper.addAttachment(
                    file.getFilename(), file);

            // Sending the mail
            javaMailSender.send(mimeMessage);
            return "Email sent successfully";
        }

        // Catch block to handle MessagingException
        catch (MessagingException e) {

            // Display message when exception occurred
            return "Email sending failed";
        }
    }

    public boolean sendMailWithAttachmentUpdated(EmailDetails details, MimeMultipart mimeMultipart) {
        // Creating a mime message
        MimeMessage mimeMessage
                = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {

            // Setting multipart as true for attachments to
            // be send
            mimeMessageHelper
                    = new MimeMessageHelper(mimeMessage, true);

            try {
                mimeMessageHelper.setFrom(new InternetAddress(sender, "Scooton"));
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            mimeMessageHelper.setTo(details.getRecipient());
            //mimeMessageHelper.setText(details.getMsgBody(),true);
            mimeMessageHelper.setSubject(
                    details.getSubject());

            mimeMessage.setContent(mimeMultipart);

            // Sending the mail
            javaMailSender.send(mimeMessage);
            return true;
        }

        // Catch block to handle MessagingException
        catch (MessagingException e) {

            // Display message when exception occurred
            return false;
        }
    }
}
