package com.example.SpringHospitalManagementSystem;


import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class NurseRepositry {

    //This is a class that will contains database (hashmap,mysql)

    HashMap<Integer,Nurse> nurseDb=new HashMap<>();

    public String addNurse(Nurse nurse){

        int key=nurse.getNurseID();
        nurseDb.put(key,nurse);

        return  "Nurse added in database successfully";
    }



    public List<Nurse> getAllNurse(){

        return nurseDb.values().stream().toList();
    }
}
