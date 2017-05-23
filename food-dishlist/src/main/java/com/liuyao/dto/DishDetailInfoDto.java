package com.liuyao.dto;

import java.io.Serializable;

/**
 * Created by xiaoliu on 2017/5/19.
 */
public class DishDetailInfoDto implements Serializable{

    private Long id;

    private Long catagoryId;

    private String pic;

    private String dishName;

    private String description;

    private Double price;

    private String unitType;

    private Long storage;

    private Long soldCount;

    private String dishStatus;

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
