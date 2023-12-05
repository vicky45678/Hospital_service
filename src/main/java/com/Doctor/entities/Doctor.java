package com.Doctor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "DOCTOR_DETAILS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "doctor_sequence", sequenceName = "DOCTOR_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctor_sequence")
    private Long doctor_Id;
    private String doctorName;
    private String department;

//    use for communication
    private Long hospitalId;

}
