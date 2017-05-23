package com.liuyao.dto;

/**
 * Created by xiaoliu on 2017/5/19.
 */
public class DishDetailInfoBuildDto {
    private Long catagoryId;    //所属分类
    private String pic;         //图片
    private String dishName;    //名称
    private String description; //描述
    private Double price;       //价格
    private Long storage;       //数目

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

    public Long getStorage() {
        return storage;
    }

    public void setStorage(Long storage) {
        this.storage = storage;
    }
}
