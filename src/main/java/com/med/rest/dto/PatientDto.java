package com.med.rest.dto;

import com.med.domain.Patient;
import com.med.domain.Write;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientDto {

    private int id;

    private String name;

    private String surname;

    private String patronymic;

    private int age;

    private String phone_number;

    private String email;


    public static PatientDto toDto(Patient patient) {

        return new PatientDto(
                patient.getId(),
                patient.getName(),
                patient.getSurname(),
                patient.getPatronymic(),
                patient.getAge(),
                patient.getPhone_number(),
                patient.getEmail()
        );
    }

    public static Patient toDomainObject(PatientDto patientDto) {

        return new Patient(
                patientDto.getId(),
                patientDto.getName(),
                patientDto.getSurname(),
                patientDto.getPatronymic(),
                patientDto.getAge(),
                patientDto.getPhone_number(),
                patientDto.getEmail()
        );
    }
}
