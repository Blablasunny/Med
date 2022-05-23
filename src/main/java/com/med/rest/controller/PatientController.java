package com.med.rest.controller;

import com.med.domain.Patient;
import com.med.rest.dto.PatientDto;
import com.med.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/patient")
    public List<PatientDto> getAllPatient() {

        List<PatientDto> patientDtoList = patientService.getAll().stream().map(PatientDto::toDto).collect(Collectors.toList());

        return patientDtoList;
    }

    @PostMapping("/patient")
    public PatientDto insertPatient(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String patronymic,
            @RequestParam int age,
            @RequestParam String phone_number,
            @RequestParam String email) {

        Patient patient = patientService.insert(
                name, surname, patronymic, age, phone_number, email);
        return PatientDto.toDto(patient);
    }

    @PutMapping("/patient/{id}")
    public PatientDto updatePatient(
            @PathVariable int id,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String patronymic,
            @RequestParam int age,
            @RequestParam String phone_number,
            @RequestParam String email) {

        Patient patient = patientService.update(
                id, name, surname, patronymic, age, phone_number, email);
        return PatientDto.toDto(patient);
    }

    @GetMapping("patient/{id}")
    public PatientDto getPatientById(@PathVariable int id) {

        Patient patient = patientService.getById(id);
        return PatientDto.toDto(patient);
    }

    @DeleteMapping("patient/{id}")
    public void deletePatient(@PathVariable int id) {

        patientService.deleteById(id);
    }
}
