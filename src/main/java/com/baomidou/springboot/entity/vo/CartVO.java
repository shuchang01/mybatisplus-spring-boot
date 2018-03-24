package com.baomidou.springboot.entity.vo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author Chris
 * @since 2018-03-24
 */
@Data
@Accessors(chain = true)
@TableName("t_cart")
public class CartVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private String sessionId;
    private Integer goodsId;
    private String goodsSn;
    private Integer productId;
    private String goodsName;
    private BigDecimal marketPrice;
    private BigDecimal retailPrice;
    private Integer number;
    /**
     * 规格属性组成的字符串，用来显示用
     */
    private String goodsSpecifitionNameValue;
    /**
     * product表对应的goods_specifition_ids
     */
    private String goodsSpecifitionIds;
    private Integer checked;
    private String listPicUrl;


}
