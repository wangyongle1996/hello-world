package com.wangyongle.clininserver.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;
import java.util.List;


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
public class Recipe extends Model<Recipe> {

    private static final long serialVersionUID = 1L;

    /**
     * 处方ID
     */
    private Integer id;

    /**
     * 患者ID
     */
    private Integer userId;

    /**
     * 诊断
     */
    private String diagnose;

    /**
     * 医嘱
     */
    private String advice;

    /**
     * 收费单ID
     */
    private Integer drugRecipeId;

    /**
     * 总价
     */
    private BigDecimal price;

    /**
     * 缴费状态
     */
    private String stauts;

    /**
     * 接诊类型
     */
    private String type;

    private List<Drug> drugs;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
