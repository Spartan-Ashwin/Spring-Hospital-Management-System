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


    @GetMapping("patientInfoUsingRequestParam")
    public  Patient getPatientInfo(@RequestParam("patientId") Integer patientId){

        Patient p=patientdb.get(patientId);

        return   p;
    }

    @GetMapping("patientInfoUsingPathVariable/{patientId}")
    public  Patient getPatientInfo1(@PathVariable ("patientId") Integer patientId){

        Patient p=patientdb.get(patientId);
        return  p;
    }


    @GetMapping("getPatientAccordingAgeAndDisease/{age}/{disease}")

    public List<Patient> getPatientAccordingAgeAndDisease (@PathVariable("age")Integer age,@PathVariable("disease") String disease){

        List<Patient> p=new ArrayList<>();

        for(int ii:patientdb.keySet()){
            Patient pp=patientdb.get(ii);

            if(pp.getAge()>age && pp.getDisease().equals(disease)){
                p.add(pp);
            }
        }
        return p;

    }


    @PutMapping("updatePatientName")

    public  String updatePatientName(@RequestBody Patient patient,@RequestParam("name")String age){


        if(patientdb.containsKey(patient.getPatientId())){
            Patient p=patient;
            int key=p.getPatientId();
            p.setName(age);
            patientdb.put(key,p);

            return  "Patient Name updated successfully";
        }else{
           return  "Patient does not exist in database";
        }
    }


    @PutMapping("updatePatientAge")

    public  String updatePatientAge(@RequestBody Patient patient,@RequestParam("age")Integer age){


        if(patientdb.containsKey(patient.getPatientId())){
            Patient p=patient;
            int key=p.getPatientId();
            p.setAge(age);
            patientdb.put(key,p);

            return  "Patient Age updated successfully";
        }else{
            return  "Patient does not exist in database";
        }
    }


    @PutMapping("updatePatientDisease")

    public  String updatePatientDisease(@RequestBody Patient patient,@RequestParam("Disease")String disease){


        if(patientdb.containsKey(patient.getPatientId())){
            Patient p=patient;
            int key=p.getPatientId();
            p.setDisease(disease);
            patientdb.put(key,p);

            return  "Patient Name updated successfully";
        }else{
            return  "Patient does not exist in database";
        }
    }


    @DeleteMapping("DeletePatient")

    public  String deletePatient(@RequestBody Patient patient,@RequestParam("patientId")int patientId){

        if(patientdb.containsKey(patientId)){

            if(patientdb.containsKey(patientId)){
                patientdb.remove(patientId);
                return "Patient Deleted Successfully";
            }else{
                return "Patient does not exit in database";
            }

        }else{

            return "Patient Deleted from database";
        }
    }





    @GetMapping("getAllPatient")

    public List<Patient> getAllPatient(){

//        List<Patient> patientList=new ArrayList<Patient>();
//
//
//        for(Patient p:patientdb.values()){
//            patientList.add(p);
//        }

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
