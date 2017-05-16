package com.liuyao.constant;

import com.sun.org.apache.regexp.internal.RE;

import java.io.Serializable;

/**
 * Created by xiaoliu on 2017/5/16.
 */
public class Result implements Serializable{

    private boolean success;

    private long code;

    private String msg;

    public Result(boolean success,String msg) {
        this.success = success;
        this.msg = msg;
    }

    public Result(boolean success, long code) {
        this.success = success;
        this.code = code;
    }

    public Result(boolean success,long code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
