package com.wangyongle.clininserver.dto;

import com.wangyongle.clininserver.entity.Drug;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
@Data
public class RecipeDto {
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

    private String orderNo;

    private List<Drug> drugs;


}
