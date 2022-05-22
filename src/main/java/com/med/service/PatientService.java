package com.med.service;

import com.med.domain.Patient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public interface PatientService {

    Patient insert(String name,
                   String surname,
                   String patronymic,
                   int age,
                   String phone_number,
                   String email);

    Patient update(int id,
                   String name,
                   String surname,
                   String patronymic,
                   int age,
                   String phone_number,
                   String email);

    List<Patient> getAll();

    void deleteById(int id);

    Patient getById(int id);
}
