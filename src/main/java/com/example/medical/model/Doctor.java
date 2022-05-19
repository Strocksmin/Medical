package com.example.medical.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "doctors")
@Getter
@Setter
public class Doctor {

    @Id
    @SequenceGenerator(name = "banks_seq", sequenceName =
            "doctors_sequence", allocationSize = 1)
    @GeneratedValue(generator = "banks_seq", strategy =
            GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "speciality")
    private String speciality;

    public Doctor(String firstName, String lastName, String speciality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;
    }

    public Doctor() {

    }
    // TODO Сделать личный кабинет врача
    // Вывод всех записанных клиентов, дата записи и т.д.
    // Веб-страница "Наши врачи"
}
