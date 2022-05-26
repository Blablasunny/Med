package com.med.rest.controller;

import com.med.domain.Write;
import com.med.rest.dto.WriteDto;
import com.med.service.DoctorService;
import com.med.service.PatientService;
import com.med.service.WriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class WriteController {

    private  final WriteService writeService;
    private  final PatientService patientService;
    private  final DoctorService doctorService;

    @GetMapping("/write")
    public List<WriteDto> getAllWrite() {

        List<WriteDto> writeDtoList = writeService.getAll().stream().map(WriteDto::toDto).collect(Collectors.toList());

        return writeDtoList;
    }

    @PostMapping("/write")
    public WriteDto insertWrite(
            @RequestParam String name,
            @RequestParam String info,
            @RequestParam int patientId,
            @RequestParam int doctorId,
            @RequestParam int dayId
    ) {

        Write write = writeService.insert(name, info, patientId, doctorId, dayId);

        return WriteDto.toDto(write);
    }

    @PutMapping("/write/{id}")
    public WriteDto updateWrite(
            @PathVariable int id,
            @RequestParam String name,
            @RequestParam String info,
            @RequestParam int patientId,
            @RequestParam int doctorId,
            @RequestParam int dayId
    ) {

        Write write = writeService.update(
                id, name, info, patientId, doctorId, dayId);
        return WriteDto.toDto(write);
    }

    @GetMapping("/write/{id}")
    public WriteDto getWriteById(@PathVariable int id) {

        Write write = writeService.getById(id);
        return WriteDto.toDto(write);
    }

    @DeleteMapping("/write/{id}")
    public void deleteWrite(@PathVariable int id) {

        writeService.deleteById(id);
    }
}

