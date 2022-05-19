package com.example.medical.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "clients")
@Getter
@Setter
public class Client {

    @javax.persistence.Id
    @Id
    @SequenceGenerator(name = "client_seq", sequenceName =
            "clients_sequence", allocationSize = 1)
    @GeneratedValue(generator = "client_seq", strategy =
            GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "date")
    private String dateTime;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "doctor")
    private String doctor;

    public Client(String dateTime, String name, String phone, String doctor) {
        this.dateTime = dateTime;
        this.name = name;
        this.phone = phone;
        this.doctor = doctor;
    }

    public Client() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}