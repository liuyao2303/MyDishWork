package com.liuyao.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by xiaoliu on 2017/5/19.
 */
public class CatagoryInfoDto implements Serializable{
    private Long catagoryId;
    private String title;           //
    private Date createTime;       //创建时间
    private Long order;             //顺序
    private String status;          //状态

    public Long getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(Long catagoryId) {
        this.catagoryId = catagoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
