package com.liuyao.dmo;

import org.hibernate.annotations.*;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by xiaoliu on 2017/5/11.
 */
@Entity
@Table(name = "user_info")
public class UserInfoDmo {

    @Id
    @GenericGenerator(name = "key",strategy = "identity")
    @GeneratedValue(generator = "key")
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "sex")
    private String sex;

    @Column(name = "phome_number")
    private String phoneNumber;

    @Column(name = "addr")
    private String addr;

    @Column(name = "age")
    private Integer age;

    @Column(name = "status")
    private String status;

    @OneToOne(targetEntity = UserLoginDmo.class)
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private UserLoginDmo userLoginDmo;

    public UserLoginDmo getUserLoginDmo() {
        return userLoginDmo;
    }

    public void setUserLoginDmo(UserLoginDmo userLoginDmo) {
        this.userLoginDmo = userLoginDmo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
