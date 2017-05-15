package com.liuyao.dmo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by xiaoliu on 2017/5/15.
 */

@Entity
public class UserLoginDmo {

    @Id
    @GenericGenerator(name = "id_gen",strategy = "identity")
    @GeneratedValue(generator = "id_gen")
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id",length = 19,nullable = false)
    private Long user_id;

    @Column(name = "password",length = 128,nullable = false)
    private String password;

    @Column(name = "open_id")
    private long openId;

    @Column(name = "status",length = 2, nullable = false)
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getOpenId() {
        return openId;
    }

    public void setOpenId(long openId) {
        this.openId = openId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
