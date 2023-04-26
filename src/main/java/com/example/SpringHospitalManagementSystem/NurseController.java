package com.example.SpringHospitalManagementSystem;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Nurse")
public class NurseController {


    NurseService nurseService=new NurseService();
    @PostMapping("add")
    public String addNurse(@RequestBody Nurse nurse){


        String ans=nurseService.addNurse(nurse);
        return  ans;
    }

    @GetMapping("getNurseAboveAge")

    public List<Nurse> getNurseAboveAge(@RequestParam("age")Integer age){

        List<Nurse> list=nurseService.getNurseAboveAge(age);
        return  list;
    }

    @GetMapping("getNurseWithQualification")

    public  List<Nurse> getNurseWithQualification(@RequestParam("qualification") String qualification){

        List<Nurse> list=nurseService.getNurseWithQualificatoin(qualification);
        return  list;
    }
}
