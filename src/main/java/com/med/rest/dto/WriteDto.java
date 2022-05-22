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
public class WriteDto {

    private int id;

    private String name;

    private String info;

    private PatientDto patientDto;

    private DoctorDto doctorDto;

    public static WriteDto toDto(Write write) {

        return new WriteDto(
                write.getId(),
                write.getName(),
                write.getInfo(),
                PatientDto.toDto(write.getPatient()),
                DoctorDto.toDto(write.getDoctor())
        );
    }

    public static Write toDomainObject(WriteDto writeDto, Patient patient, Doctor doctor) {

        return new Write(
                writeDto.getId(),
                writeDto.getName(),
                writeDto.getInfo(),
                patient,
                doctor
        );
    }
}
