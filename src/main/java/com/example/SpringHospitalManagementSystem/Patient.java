package com.example.SpringHospitalManagementSystem;

public class Patient {

    private  int patientId;
    private  int age;
    private  String name;

    private  String  disease;


    Patient(int patientId,String name,int age,String disease){
        this.patientId=patientId;
        this.name=name;
        this.age=age;
        this.disease=disease;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return  name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getDisease() {
        return disease;
    }
}
