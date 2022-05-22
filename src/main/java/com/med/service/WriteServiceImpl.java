package com.med.service;

import com.med.domain.Doctor;
import com.med.domain.Patient;
import com.med.domain.Write;
import com.med.repository.DoctorRepository;
import com.med.repository.PatientRepository;
import com.med.repository.WriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WriteServiceImpl implements WriteService {

    private final WriteRepository writeRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Override
    public Write insert(String name, String info, int idPatient, int idDoctor) {

        Patient patient = patientRepository.findById(idPatient).orElse(null);

        Doctor doctor = doctorRepository.findById(idDoctor).orElse(null);

        Write write = Write.builder()
                .name(name)
                .info(info)
                .patient(patient)
                .doctor(doctor)
                .build();

        return writeRepository.save(write);
    }

    @Override
    public Write update(int id, String name, String info, int idPatient, int idDoctor) {

        Patient patient = patientRepository.findById(idPatient).orElse(null);

        Doctor doctor = doctorRepository.findById(idDoctor).orElse(null);

        Write write = Write.builder()
                .id(id)
                .name(name)
                .info(info)
                .patient(patient)
                .doctor(doctor)
                .build();

        return writeRepository.save(write);
    }

    @Override
    public List<Write> getAll() {

        return writeRepository.findAll();
    }

    @Override
    public void deleteById(int id) {

        writeRepository.getById(id);
    }

    @Override
    public Write getById(int id) {

        return writeRepository.getById(id);
    }
}
