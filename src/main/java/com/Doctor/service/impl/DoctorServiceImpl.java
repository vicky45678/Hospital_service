package com.Doctor.service.impl;

import com.Doctor.entities.Doctor;
import com.Doctor.repository.DoctorRepository;
import com.Doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor add(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> get() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getOne(Long Id) {
        return doctorRepository.findById(Id).orElseThrow(()-> new RuntimeException("Doctor Not found"));
    }

    @Override
    public List<Doctor> getHospitalOfDoctor(Long hospitalId) {
        return doctorRepository.findByhospitalId(hospitalId);
    }

    @Override
    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public void updateDoctor(Long id, Doctor updateDoctor) {
        Doctor doctors=doctorRepository.findById(id).orElse(null);

        if (doctors !=null){
            doctors.setDoctorName(updateDoctor.getDoctorName());
            doctors.setDepartment(updateDoctor.getDepartment());

            doctorRepository.save(doctors);
        }
    }

}
