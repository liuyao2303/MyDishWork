package com.liuyao.dto;

/**
 * Created by xiaoliu on 2017/5/16.
 */
public class UserLoginDto {

    private Long id;
    private Long userId;
    private String password;
    private long openId;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return "UserLoginDto{" +
                "id=" + id +
                ", userId=" + userId +
                ", password='" + password + '\'' +
                ", openId=" + openId +
                ", status='" + status + '\'' +
                '}';
    }
}
