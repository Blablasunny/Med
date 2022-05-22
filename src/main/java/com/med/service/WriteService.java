package com.med.service;

import com.med.domain.Write;

import java.util.List;

public interface WriteService {

    Write insert(String name,
                String info,
                int idPatient,
                int idDoctor);

    Write update(int id,
                String name,
                String info,
                int idPatient,
                int idDoctor);

    List<Write> getAll();

    void deleteById(int id);

    Write getById(int id);

}
