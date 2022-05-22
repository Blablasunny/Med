package com.med.service;

import com.med.domain.Patient;
import com.med.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public Patient insert(String name, String surname, String patronymic, int age, String phone_number, String email) {

        Patient patient = Patient.builder()
                .name(name)
                .surname(surname)
                .patronymic(patronymic)
                .age(age)
                .phone_number(phone_number)
                .email(email)
                .build();

        return patientRepository.save(patient);
    }

    @Override
    public Patient update(int id, String name, String surname, String patronymic, int age, String phone_number, String email) {

        Patient patient = Patient.builder()
                .id(id)
                .name(name)
                .surname(surname)
                .patronymic(patronymic)
                .age(age)
                .phone_number(phone_number)
                .email(email)
                .build();

        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAll() {

        return patientRepository.findAll();
    }

    @Override
    public void deleteById(int id) {

        patientRepository.deleteById(id);
    }

    @Override
    public Patient getById(int id) {

        return patientRepository.getById(id);
    }
}
