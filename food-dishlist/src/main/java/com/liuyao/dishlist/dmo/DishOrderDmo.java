package com.liuyao.dishlist.dmo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by xiaoliu on 2017/5/15. 1111
 */
@Entity
public class DishOrderDmo {

    /*订单id*/
    @Id
    @GenericGenerator(name = "dishorder_id",strategy = "Identity")
    @GeneratedValue(generator = "dishorder_id")
    @Column(name = "id")
    private long id;

    /*下单的用户id*/
    @Column(name = "user_id")
    private long userId;

    /*下单时间*/
    @Column(name = "create_time")
    private Date createTime;

    /*订单时效*/
    @Column(name = "dead_line")
    private Date deadLine;

    /*金额统计*/
    @Column(name = "total")
    private double total;

    /*支付状态*/
    @Column(name = "pay_status")
    private String payStatus;

    /*支付类型*/
    @Column(name = "pay_type")
    private String payType;

    /*订单状态*/
    @Column(name = "status")
    private String status;
}
