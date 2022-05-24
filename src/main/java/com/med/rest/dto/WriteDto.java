package com.med.rest.dto;

import com.med.domain.Day;
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

    private int patientId;

    private int doctorId;

    private int dayId;

    public static WriteDto toDto(Write write) {

        return new WriteDto(
                write.getId(),
                write.getName(),
                write.getInfo(),
                write.getPatient().getId(),
                write.getDoctor().getId(),
                write.getDay().getId()
        );
    }

    public static Write toDomainObject(WriteDto writeDto, Patient patient, Doctor doctor, Day day) {

        return new Write(
                writeDto.getId(),
                writeDto.getName(),
                writeDto.getInfo(),
                patient,
                doctor,
                day
        );
    }
}
