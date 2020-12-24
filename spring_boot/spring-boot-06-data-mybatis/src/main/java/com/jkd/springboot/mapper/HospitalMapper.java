package com.jkd.springboot.mapper;


import com.jkd.springboot.bean.Hospital;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//@Mapper
public interface HospitalMapper {


    @Select("select * from hospital_info where hospital_id=#{hospitalId}")
    public Hospital getHospitalId(String hospitalId);
}
