package com.wangyongle.clininserver.entity;

import java.math.BigDecimal;
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
public class Drug extends Model<Drug> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 药品名称
     */
    private String name;

    /**
     * 药品规格
     */
    private String type;

    /**
     * 药品库存
     */
    private Integer inventory;

    /**
     * 药品价格
     */
    private BigDecimal price;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
