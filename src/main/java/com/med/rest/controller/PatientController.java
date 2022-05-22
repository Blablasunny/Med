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

//    @PutMapping("/book/{id}")
//    public  BookDto updateBook(@PathVariable int id,
//                               @RequestParam String nameBook,
//                               @RequestParam String nameAuthor,
//                               @RequestParam String nameGenre){
//
//        Book book = bookService.update(id, nameBook, nameAuthor, nameGenre);
//        return BookDto.toDto(book);
//    }
//
//    @GetMapping("/book/{id}")
//    public  BookDto getBookById(@PathVariable int id){
//
//        Book book = bookService.getById(id);
//        return BookDto.toDto(book);
//    }
//
//    @DeleteMapping("/book/{id}")
//    public  void deleteBook(@PathVariable int id){
//
//        bookService.deleteById(id);
//    }

}
