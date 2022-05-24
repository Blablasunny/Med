package com.med.service;

import com.med.domain.Day;
import com.med.repository.DayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DayServiceImpl implements DayService {

    private final DayRepository dayRepository;

    @Override
    public Day insert(String date) {

        Day day = Day.builder()
                .date(date)
                .build();

        return dayRepository.save(day);
    }

    @Override
    public Day update(int id, String date) {

        Day day = Day.builder()
                .id(id)
                .date(date)
                .build();

        return dayRepository.save(day);
    }

    @Override
    public List<Day> getAll() {

        return dayRepository.findAll();
    }

    @Override
    public Day getById(int id) {

        return dayRepository.getById(id);
    }

    @Override
    public void deleteById(int id) {

        dayRepository.deleteById(id);
    }
}
