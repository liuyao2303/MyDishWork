package com.liuyao.dto;

/**
 * Created by xiaoliu on 2017/5/19.
 */
public class ChangCataOrderDto {
    private Long CatagoryId;
    private Long order;

    public Long getCatagoryId() {
        return CatagoryId;
    }

    public void setCatagoryId(Long catagoryId) {
        CatagoryId = catagoryId;
    }

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
    }
}
