package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class EmailDetails {
    private String[] recipient;
    private String msgBody;
    private String subject;
    private String attachment;


    @Override
    public String toString() {
        return "EmailDetails{" +
                "recipient=" + recipient +
                ", msgBody='" + msgBody + '\'' +
                ", subject='" + subject + '\'' +
                ", attachment='" + attachment + '\'' +
                '}';
    }
}
