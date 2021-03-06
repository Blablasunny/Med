package com.med.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "write")
public class Write {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "info")
    private String info;

    @ManyToOne(targetEntity = Patient.class, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(targetEntity = Doctor.class, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne(targetEntity = Day.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "day_id")
    private Day day;

}
