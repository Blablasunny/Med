package com.med.rest.dto;

import com.med.domain.Doctor;
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
public class DoctorDto {

    private int id;

    private String name;

    private String surname;

    private String patronymic;

    private int age;

    private String phone_number;

    private String email;

    public static DoctorDto toDto(Doctor doctor) {

        return new DoctorDto(
                doctor.getId(),
                doctor.getName(),
                doctor.getSurname(),
                doctor.getPatronymic(),
                doctor.getAge(),
                doctor.getPhone_number(),
                doctor.getEmail()
        );
    }

    public static Doctor toDomainObject(DoctorDto doctorDto) {

        return new Doctor(
                doctorDto.getId(),
                doctorDto.getName(),
                doctorDto.getSurname(),
                doctorDto.getPatronymic(),
                doctorDto.getAge(),
                doctorDto.getPhone_number(),
                doctorDto.getEmail()
        );
    }
}
