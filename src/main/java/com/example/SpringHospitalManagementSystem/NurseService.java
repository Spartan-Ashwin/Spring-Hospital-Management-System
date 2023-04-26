package com.example.SpringHospitalManagementSystem;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class NurseService {


    NurseRepositry nurseRepositry=new NurseRepositry();
    public  String addNurse(Nurse nurse){
        return nurseRepositry.addNurse(nurse);
    }

    public  List<Nurse> getNurseAboveAge(int  age){

        List<Nurse> list1=nurseRepositry.getAllNurse();

        List<Nurse> ans=new ArrayList<>();

        for(Nurse n:list1){

            if(n.getAge()>age){
                ans.add(n);
            }
        }
        return  ans;
    }

    public  List<Nurse> getNurseWithQualificatoin(String qualification){

        List<Nurse> list=nurseRepositry.getAllNurse();
        List<Nurse> ans=new ArrayList<>();

        for(Nurse n:list){
            if(n.getQualification().equals(qualification)){
                ans.add(n);
            }
        }
        return  ans;
    }


}
