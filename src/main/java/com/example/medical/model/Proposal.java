package com.example.medical.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Getter
@Setter
public class Proposal {

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateTime;
    private String name;
    private String phone;
    private String email;
    private String doctor;

    public Proposal(LocalDateTime dateTime, String name, String phone, String email, String doctor) {
        this.dateTime = dateTime;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.doctor = doctor;
    }
}
