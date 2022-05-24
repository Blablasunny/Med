package com.med.rest.controller;

import com.med.domain.Doctor;
import com.med.domain.Patient;
import com.med.rest.dto.DoctorDto;
import com.med.service.DoctorService;
import com.med.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;
    private  final PatientService patientService;

    @GetMapping("/doctor")
    public List<DoctorDto> getAllDoctor() {

        List<DoctorDto> doctorDtoList = doctorService.getAll().stream().map(DoctorDto::toDto).collect(Collectors.toList());

        return doctorDtoList;
    }

    @PostMapping("/doctor")
    public DoctorDto insertDoctor(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String patronymic,
            @RequestParam int age,
            @RequestParam String phone_number,
            @RequestParam String email) {

        Doctor doctor = doctorService.insert(
                name, surname, patronymic, age, phone_number, email);
        return DoctorDto.toDto(doctor);
    }

    @PutMapping("/doctor/{id}")
    public DoctorDto updateDoctor(
            @PathVariable int id,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String patronymic,
            @RequestParam int age,
            @RequestParam String phone_number,
            @RequestParam String email) {

        Doctor doctor = doctorService.update(
                id, name, surname, patronymic, age, phone_number, email);
        return DoctorDto.toDto(doctor);
    }

    @GetMapping("/doctor/{id}")
    public DoctorDto getDoctorById(@PathVariable int id) {

        Doctor doctor = doctorService.getById(id);
        return DoctorDto.toDto(doctor);
    }

    @DeleteMapping("/doctor/{id}")
    public void deleteDoctor(@PathVariable int id) {

        doctorService.deleteById(id);
    }
}
