package com.wangyongle.clininserver.entity;

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
public class DrugRecipe extends Model<DrugRecipe> {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 处方ID
     */
    private String recipe;

    /**
     * 药品ID
     */
    private Integer drugId;

    /**
     * 药品数量
     */
    private Integer num;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
