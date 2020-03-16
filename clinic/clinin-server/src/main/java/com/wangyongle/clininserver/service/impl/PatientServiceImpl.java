package com.wangyongle.clininserver.service.impl;

import com.wangyongle.clininserver.entity.Patient;
import com.wangyongle.clininserver.mapper.PatientMapper;
import com.wangyongle.clininserver.service.IPatientService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Mht
 * @since 2020-03-16
 */
@Service
public class PatientServiceImpl extends ServiceImpl<PatientMapper, Patient> implements IPatientService {

}
