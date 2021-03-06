package com.example.medical.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "proposals")
@Getter
@Setter
public class Proposal {

    @javax.persistence.Id
    @Id
    @SequenceGenerator(name = "banks_seq", sequenceName =
            "proposalss_sequence", allocationSize = 1)
    @GeneratedValue(generator = "banks_seq", strategy =
            GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateTime;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "doctor")
    private String doctor;

    public Proposal(LocalDateTime dateTime, String name, String phone, String email, String doctor) {
        this.dateTime = dateTime;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.doctor = doctor;
    }

    public Proposal() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
