package com.wangyongle.clininserver.dto;

import lombok.Data;

@Data
public class PatientDto {
    private Integer id;

    /**
     * 患者编号
     */
    private String code;

    /**
     * 患者姓名
     */
    private String name;

    /**
     * 患者年龄
     */
    private Integer age;

    /**
     * 出生日期
     */
    private String birthday;

    /**
     * 患者性别
     */
    private String sex;

    /**
     * 电话
     */
    private String phone;

    /**
     * 身份证号
     */
    private String number;

    /**
     * 地址
     */
    private String address;

    /**
     * 详细地址
     */
    private String detailed;


}
