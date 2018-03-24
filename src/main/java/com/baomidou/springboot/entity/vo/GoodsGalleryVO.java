package com.baomidou.springboot.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
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
 * @author Chris
 * @since 2018-03-24
 */
@Data
@Accessors(chain = true)
@TableName("t_goods_gallery")
public class GoodsGallery implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer goodsId;
    private String imgUrl;
    private String imgDesc;
    private Integer sortOrder;


}
