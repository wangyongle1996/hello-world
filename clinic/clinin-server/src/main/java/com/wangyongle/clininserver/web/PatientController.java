package com.wangyongle.clininserver.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.wangyongle.clininserver.dto.PatientDto;
import com.wangyongle.clininserver.entity.Patient;
import com.wangyongle.clininserver.service.IPatientService;
import com.wangyongle.clininserver.vo.ResultEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Mht
 * @since 2020-03-16
 */
@CrossOrigin
@RestController
@RequestMapping("/clinic/patient")
public class PatientController {
    @Autowired
    IPatientService iPatientService;

    /**
     * 获取患者信息并填入文本框
     * @param patientDto
     * @return
     */
    @RequestMapping("/get")
    public ResultEntity get(PatientDto patientDto){
        Wrapper<Patient> wrapper = new EntityWrapper<>();
        wrapper.like("name",patientDto.getName());
//        wrapper.eq("phone",patientDto.getPhone());
//        wrapper.eq("number",patientDto.getNumber());
        Patient patient = iPatientService.selectOne(wrapper);
        return ResultEntity.ok(patient);
    }

    /**
     * 展示患者列表
     * @return
     */
    @RequestMapping("/list")
    public ResultEntity list(PatientDto patientDto){
        Wrapper<Patient> wrapper = new EntityWrapper<Patient>();
        wrapper.eq("name",patientDto.getName());
        List<Patient> patients = iPatientService.selectList(wrapper);
        return ResultEntity.ok(patients);
    }

    @RequestMapping("add")
    public ResultEntity add(PatientDto patientDto){
        Patient patient = new Patient();
        BeanUtils.copyProperties(patientDto, patient);
        return ResultEntity.ok("添加成功",iPatientService.insert(patient));
    }
}
