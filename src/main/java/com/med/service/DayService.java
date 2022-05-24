package com.med.service;

import com.med.domain.Day;

import java.util.List;

public interface DayService {

    Day insert(String date);

    Day update(int id,
                String date);

    List<Day> getAll();

    Day getById(int id);

    void deleteById(int id);

}
