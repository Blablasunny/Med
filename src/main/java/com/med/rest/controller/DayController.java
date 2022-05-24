package com.med.rest.controller;

import com.med.domain.Day;
import com.med.rest.dto.DayDto;
import com.med.service.DayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class DayController {

    private final DayService dayService;

    @GetMapping("day")
    public List<DayDto> getAllDay() {

        List<DayDto> dayDtoList =dayService.getAll().stream().map(DayDto::toDto).collect(Collectors.toList());

        return dayDtoList;
    }

    @PostMapping("/day")
    public DayDto insertDay(@RequestParam String date) {

        Day day = dayService.insert(date);

        return DayDto.toDto(day);
    }

    @GetMapping("day/{id}")
    public DayDto getDayById(@PathVariable int id) {

        Day day = dayService.getById(id);
        return DayDto.toDto(day);
    }
}

