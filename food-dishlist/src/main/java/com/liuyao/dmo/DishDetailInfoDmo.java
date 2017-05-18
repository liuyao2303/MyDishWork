package com.liuyao.dmo;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by xiaoliu on 2017/5/17.
 */
@Entity
@Table(name = "dish_detail_info")
public class DishDetailInfoDmo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @org.hibernate.annotations.ForeignKey(name = "null")
    private Long id;

    @Column(name = "catagory_id")
    private Long catagoryId;    //所属分类

    @Column(name = "pic")
    private String pic;         //图片

    @Column(name = "dish_name")
    private String dishName;    //名称

    @Column(name = "description")
    private String description; //描述

    @Column(name = "price")
    private Double price;       //价格

    @Column(name = "unit_type")
    private String unitType;    //单位

    @Column(name = "storge")
    private Long storage;       //数目

    @Column(name = "sold_count")
    private Long soldCount;     //已售数量

    @Column(name = "dish_status")
    private String dishStatus;  //状态

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(Long catagoryId) {
        this.catagoryId = catagoryId;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public Long getStorage() {
        return storage;
    }

    public void setStorage(Long storage) {
        this.storage = storage;
    }

    public Long getSoldCount() {
        return soldCount;
    }

    public void setSoldCount(Long soldCount) {
        this.soldCount = soldCount;
    }

    public String getDishStatus() {
        return dishStatus;
    }

    public void setDishStatus(String dishStatus) {
        this.dishStatus = dishStatus;
    }
}
