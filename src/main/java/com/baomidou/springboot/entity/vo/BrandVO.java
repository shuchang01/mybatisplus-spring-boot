package com.baomidou.springboot.entity.vo;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 品牌表
 * </p>
 *
 * @author K神带你飞
 * @since 2018-02-02
 */
@NoArgsConstructor
@EqualsAndHashCode
//@TableName("t_brand")
public class BrandVO implements Serializable {

    private static final long serialVersionUID = 1L;

//    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private String listPicUrl;
    private String simpleDesc;
    private String picUrl;
    private Integer sortOrder;
    private Integer isShow;
    private BigDecimal floorPrice;
    private String appListPicUrl;
    private Integer isNew;
    private String newPicUrl;
    private Integer newSortOrder;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getListPicUrl() {
        return listPicUrl;
    }

    public void setListPicUrl(String listPicUrl) {
        this.listPicUrl = listPicUrl;
    }

    public String getSimpleDesc() {
        return simpleDesc;
    }

    public void setSimpleDesc(String simpleDesc) {
        this.simpleDesc = simpleDesc;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public BigDecimal getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(BigDecimal floorPrice) {
        this.floorPrice = floorPrice;
    }

    public String getAppListPicUrl() {
        return appListPicUrl;
    }

    public void setAppListPicUrl(String appListPicUrl) {
        this.appListPicUrl = appListPicUrl;
    }

    public Integer getIsNew() {
        return isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }

    public String getNewPicUrl() {
        return newPicUrl;
    }

    public void setNewPicUrl(String newPicUrl) {
        this.newPicUrl = newPicUrl;
    }

    public Integer getNewSortOrder() {
        return newSortOrder;
    }

    public void setNewSortOrder(Integer newSortOrder) {
        this.newSortOrder = newSortOrder;
    }

    @Override
    public String toString() {
        return "BrandVO {" +
        ", id=" + id +
        ", name=" + name +
        ", listPicUrl=" + listPicUrl +
        ", simpleDesc=" + simpleDesc +
        ", picUrl=" + picUrl +
        ", sortOrder=" + sortOrder +
        ", isShow=" + isShow +
        ", floorPrice=" + floorPrice +
        ", appListPicUrl=" + appListPicUrl +
        ", isNew=" + isNew +
        ", newPicUrl=" + newPicUrl +
        ", newSortOrder=" + newSortOrder +
        " }";
    }
}
