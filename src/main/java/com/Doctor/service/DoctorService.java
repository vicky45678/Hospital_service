package com.Doctor.service;

import com.Doctor.entities.Doctor;

import java.util.List;

public interface DoctorService {

    Doctor add(Doctor doctor);

    List<Doctor> get();

    Doctor getOne(Long Id);

    List<Doctor> getHospitalOfDoctor(Long hospitalId);

    void deleteDoctorById(Long id);

    void updateDoctor(Long id, Doctor updateDoctor);


}
