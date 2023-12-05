package com.Doctor.controller;

import com.Doctor.entities.Doctor;
import com.Doctor.service.DoctorService;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public Doctor create(@RequestBody Doctor doctor){
        return doctorService.add(doctor);
    }

    @GetMapping
    public List<Doctor> getall(){
        return  doctorService.get();
    }

    @GetMapping("/{id}")
    public Doctor getById(@PathVariable Long id){
        return doctorService.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctorById(@PathVariable Long id){
        doctorService.deleteDoctorById(id);
        System.out.print("Deleted Succesfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDoctor(@PathVariable Long id, @RequestBody Doctor updatedoctor){
        doctorService.updateDoctor(id,updatedoctor);
        return ResponseEntity.ok("Update Successfully");

    }
// this api is use for communication
    @GetMapping("/hospital/{hospitalId}")
    public List<Doctor> getHospitalOfDoctor(@PathVariable Long hospitalId){
        return doctorService.getHospitalOfDoctor(hospitalId);
    }


}
