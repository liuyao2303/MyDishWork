package com.liuyao.dmo;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by xiaoliu on 2017/5/18.
 */
@Entity
@Table(name = "dish_catagory_info")
public class CatagoryInfoDmo {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "catagory_id")
    private Long catagoryId;

    @Column(name = "title",length = 64)
    private String title;           //

    @Column(name = "createTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;       //创建时间

    @Column(name = "sorting_order",length = 10)
    private Long order;             //顺序

    @Column(name = "status",length = 2)
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
