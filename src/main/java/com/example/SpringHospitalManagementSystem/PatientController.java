package com.example.SpringHospitalManagementSystem;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class PatientController {

    HashMap<Integer,Patient> patientdb=new HashMap<>();


    //WAY -01
    @PostMapping("addPatientViaParameter")
    public  String addPatient(@RequestParam("patientId") Integer patientId,
                              @RequestParam("name") String name, @RequestParam("age") Integer age,
                              @RequestParam("disease") String disease){

        Patient patient=new Patient(patientId,name,age,disease);
        patientdb.put(patientId,patient);
        return "Patient added successfully via parameter";
    }

    //WAY -02

    @PostMapping("addPatientViaRequestBody")
    public  String addPatient(@RequestBody Patient patient){
        int key=patient.getPatientId();
        patientdb.put(key,patient);
        return "Patient added successfully via request body";
    }

    @GetMapping("getPatientInfo")

    public Patient getPatientInfo(@RequestParam("patientId")Integer patientId){
        return patientdb.get(patientId);
    }

    @GetMapping("getAllPatient")

    public List<Patient> getAllPatient(){

//        List<Patient> patientList=new ArrayList<Patient>();
//
//
//        for(Patient p:patientdb.values()){
//            patientList.add(p);
//        }
//
//        return  patientList;

        return patientdb.values().stream().toList();
    }

    @GetMapping("getPatientGreaterThanAge")
    public List<Patient> getPatientGreaterThanAge(@RequestParam("age")Integer age){
        List<Patient> patientList=new ArrayList<>();

        for(Patient p:patientdb.values()){
            if(p.getAge()>age){
                patientList.add(p);
            }
        }
        return  patientList;
    }
}
