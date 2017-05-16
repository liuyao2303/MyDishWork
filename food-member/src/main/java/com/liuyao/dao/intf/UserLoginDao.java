package com.liuyao.dao.intf;

import com.liuyao.dmo.UserLoginDmo;

/**
 * Created by xiaoliu on 2017/5/16.
 */
public interface UserLoginDao {
    public Long addUserLoginInfo(UserLoginDmo loginDmo) ;
    public UserLoginDmo getUserLoginInfo(Long userId) ;
}
