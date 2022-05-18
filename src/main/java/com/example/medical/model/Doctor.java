package com.example.medical.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Doctor {

    private String firstName;
    private String lastName;

    private String speciality;

    public Doctor(String firstName, String lastName, String speciality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;
    }
}
