package com.example.SpringHospitalManagementSystem;

public class Doctor {

    private int doctorId;

    private  String doctorName;

    private String degree;

    public Doctor(int doctorId,String doctorName,String degree){
        this.doctorId=doctorId;
        this.doctorName=doctorName;
        this.degree=degree;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getDoctorId(){
        return doctorId;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorName(){
        return doctorName;
    }

    public void setDegree(String degree){
        this.degree=degree;
    }

    public String getDegree(){
        return  degree;
    }
}
