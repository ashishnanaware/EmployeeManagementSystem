package com.example.controller;

import com.example.entity.EmailDetails;
import com.example.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emails")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping
    public String sendEmail(@RequestBody EmailDetails details)
    {
        return emailService.sendMailWithAttachment(details);

    }
    @GetMapping
    public String sendEmail(){
        return emailService.sendEmail();
    }


}
