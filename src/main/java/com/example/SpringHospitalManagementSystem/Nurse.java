package com.example.SpringHospitalManagementSystem;

public class Nurse {

    private  int nurseID;
    private  String nurseName;

    private  int age;
    private  String qualification;


    public Nurse(int nurseID,String nurseName,int age,String qualification){

        this.nurseID=nurseID;
        this.age=age;
        this.nurseName=nurseName;
        this.qualification=qualification;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setNurseID(int nurseID) {
        this.nurseID = nurseID;
    }

    public int getNurseID() {
        return nurseID;
    }

    public void setNurseName(String nurseName) {
        this.nurseName = nurseName;
    }

    public String getNurseName() {
        return nurseName;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getQualification() {
        return qualification;
    }
}
