package com.jkd.springboot.controller;

import com.jkd.springboot.bean.Hospital;
import com.jkd.springboot.mapper.HospitalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HospitalController {

    @Autowired
    HospitalMapper hospitalMapper;
    @GetMapping("/hospital/{id}")
    public Hospital getHospital(@PathVariable("id") String id){
        Hospital hospital = hospitalMapper.getHospitalId(id);
        return hospital;
    }
}
