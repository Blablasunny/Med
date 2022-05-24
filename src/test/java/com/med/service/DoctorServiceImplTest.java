package com.med.service;

import com.med.domain.Doctor;
import com.med.repository.DoctorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@DisplayName("class DoctorServiceImplTest")
@ExtendWith(MockitoExtension.class)
public class DoctorServiceImplTest {

    public static final int EXISTING_ID1 = 1;
    public static final String EXISTING_NAME1 = "Имя 1";
    public static final String EXISTING_SURNAME1 = "Фамилия 1";
    public static final String EXISTING_PATRONYMIC1 = "Отчество 1";
    public static final int EXISTING_AGE1 = 23;
    public static final String EXISTING_PHONE_NUMBER1 = "Телефон 1";
    public static final String EXISTING_EMAIL1 = "Почта 1";

    public static final int EXISTING_ID2 = 2;
    public static final String EXISTING_NAME2 = "Имя 2";
    public static final String EXISTING_SURNAME2 = "Фамилия 2";
    public static final String EXISTING_PATRONYMIC2 = "Отчество 2";
    public static final int EXISTING_AGE2 = 35;
    public static final String EXISTING_PHONE_NUMBER2 = "Телефон 2";
    public static final String EXISTING_EMAIL2 = "Почта 2";

    public static final int EXISTING_ID3 = 3;
    public static final String EXISTING_NAME3 = "Имя 3";
    public static final String EXISTING_SURNAME3 = "Фамилия 3";
    public static final String EXISTING_PATRONYMIC3 = "Отчество 3";
    public static final int EXISTING_AGE3 = 28;
    public static final String EXISTING_PHONE_NUMBER3 = "Телефон 3";
    public static final String EXISTING_EMAIL3 = "Почта 3";


    private DoctorService doctorService;

    @Mock
    private DoctorRepository doctorRepository;

    private List<Doctor> doctorList;

    @BeforeEach
    void init() {
        doctorList = new ArrayList<>();

        Doctor expectedDoctor1 = Doctor.builder()
                .id(EXISTING_ID1)
                .name(EXISTING_NAME1)
                .surname(EXISTING_SURNAME1)
                .patronymic(EXISTING_PATRONYMIC1)
                .age(EXISTING_AGE1)
                .phone_number(EXISTING_PHONE_NUMBER1)
                .email(EXISTING_EMAIL1)
                .build();

        Doctor expectedDoctor2 = Doctor.builder()
                .id(EXISTING_ID2)
                .name(EXISTING_NAME2)
                .surname(EXISTING_SURNAME2)
                .patronymic(EXISTING_PATRONYMIC2)
                .age(EXISTING_AGE2)
                .phone_number(EXISTING_PHONE_NUMBER2)
                .email(EXISTING_EMAIL2)
                .build();

        Doctor expectedDoctor3 = Doctor.builder()
                .id(EXISTING_ID3)
                .name(EXISTING_NAME3)
                .surname(EXISTING_SURNAME3)
                .patronymic(EXISTING_PATRONYMIC3)
                .age(EXISTING_AGE3)
                .phone_number(EXISTING_PHONE_NUMBER3)
                .email(EXISTING_EMAIL3)
                .build();

        doctorList.add(expectedDoctor1);
        doctorList.add(expectedDoctor2);
        doctorList.add(expectedDoctor3);


        doctorService = new DoctorServiceImpl(doctorRepository);
    }

    @DisplayName("Должен добавлять врача в базу данных")
    @Test
    void shouldInsertDoctor() {

        Doctor expectedDoctor = Doctor.builder()
                .name("Имя 4")
                .surname("Фамилия 4")
                .patronymic("Отчество 4")
                .age(25)
                .phone_number("+79854323212")
                .email("vas24@mail.ru")
                .build();

        when(doctorRepository.save(expectedDoctor)).thenReturn(expectedDoctor);

        Doctor doctor = doctorService.insert("Имя 4",
                "Фамилия 4",
                "Отчество 4",
                25,
                "+79854323212",
                "vas24@mail.ru");

        assertThat(expectedDoctor).isEqualTo(doctor);
    }

    @DisplayName("Должен возвращать всех врачей")
    @Test
    void shouldGetAllDoctors() {

        when(doctorRepository.findAll()).thenReturn(doctorList);

        List<Doctor> doctors = doctorService.getAll();

        assertThat(doctorList).isEqualTo(doctors);
    }

    @DisplayName("Должен возвращать информацию о враче по id")
    @Test
    void  shouldGetDoctorById() {

        when(doctorRepository.getById(2)).thenReturn(doctorList.get(2));

        Doctor doctor = doctorService.getById(2);

        assertThat(doctorList.get(2)).isEqualTo(doctor);
    }

//    @DisplayName("Должен обновлять врача")
//    @Test
//    void shouldUpdateDoctor() {
//
//        Doctor expectedDoctor = Doctor.builder()
//                .id(1)
//                .name("Имя 4")
//                .surname("Фамилия 4")
//                .patronymic("Отчество 4")
//                .age(50)
//                .phone_number("+79854323212")
//                .email("vas24@mail.ru")
//                .build();
//
//        when(doctorRepository.save(expectedDoctor)).thenReturn(expectedDoctor);
//
//        Doctor doctor = doctorService.update(1,
//                "Имя 4",
//                "Фамилия 4",
//                "Отчество 4",
//                50,
//                "+79854323212",
//                "vas24@mail.ru");
//
//        assertThat(expectedDoctor).isEqualTo(doctor);
//    }
}
