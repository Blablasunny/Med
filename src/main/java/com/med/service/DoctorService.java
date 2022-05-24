package com.med.service;

import com.med.domain.Doctor;
import com.med.domain.Patient;

import java.util.List;

public interface DoctorService {

    Doctor insert(String name,
                  String surname,
                  String patronymic,
                  int age,
                  String phone_number,
                  String email);

    Doctor update(int id,
                String name,
                String surname,
                String patronymic,
                int age,
                String phone_number,
                String email,
                List<Patient> patientList);

    List<Doctor> getAll();

    void deleteById(int id);

    Doctor getById(int id);

}
