package com.example.medical.service;

import com.example.medical.data.MessageData;
import com.example.medical.model.Proposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;

public class EmailService {
    @Autowired
    public JavaMailSender emailSender;

    @Async
    public void sendMessageEmail(MessageData messageData){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("medcityapp@bk.ru");
        message.setTo("medcityapp@bk.ru");
        message.setSubject("Сообщение от клиента " + messageData.getName());
        message.setText("Текст: " + messageData.getText() + " Телефон " + messageData.getPhone());
        this.emailSender.send(message);
        System.out.println("Сообщение отправлено");
    }

    @Async
    public void sendProposalEmail(Proposal proposal, String speciality, String date){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("medcityapp@bk.ru");
        message.setTo(proposal.getEmail());
        message.setSubject(proposal.getName() + ", ваша запись");
        message.setText(proposal.getName() + ", вы записаны к " + speciality + ". Дата: " + date);
        this.emailSender.send(message);
        System.out.println("Сообщение отправлено");
    }
}
