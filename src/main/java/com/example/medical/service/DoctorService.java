package com.example.medical.service;

import com.example.medical.model.Doctor;
import com.example.medical.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public List<Doctor> getDoctors() {
        return doctorRepository.findAll();
    }

}
