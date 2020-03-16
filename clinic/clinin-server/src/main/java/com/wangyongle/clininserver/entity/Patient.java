package com.wangyongle.clininserver.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;



import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Mht
 * @since 2020-03-16
 */
@Data
@Accessors(chain = true)
public class Patient extends Model<Patient> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
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


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
