package com.med.service;

import com.med.domain.Doctor;
import com.med.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public Doctor insert(String name, String surname, String patronymic, int age, String phone_number, String email) {

        Doctor doctor = Doctor.builder()
                .name(name)
                .surname(surname)
                .patronymic(patronymic)
                .age(age)
                .phone_number(phone_number)
                .email(email)
                .build();

        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor update(int id, String name, String surname, String patronymic, int age, String phone_number, String email) {

        Doctor doctor = Doctor.builder()
                .id(id)
                .name(name)
                .surname(surname)
                .patronymic(patronymic)
                .age(age)
                .phone_number(phone_number)
                .email(email)
                .build();

        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAll() {

        return doctorRepository.findAll();
    }

    @Override
    public void deleteById(int id) {

        doctorRepository.deleteById(id);
    }

    @Override
    public Doctor getById(int id) {

        return doctorRepository.getById(id);
    }
}
