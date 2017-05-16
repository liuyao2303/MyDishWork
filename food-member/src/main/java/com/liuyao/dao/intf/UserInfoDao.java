package com.liuyao.dao.intf;

import com.liuyao.dmo.UserInfoDmo;
import com.liuyao.dmo.UserLoginDmo;

import java.util.List;

/**
 * Created by xiaoliu on 2017/5/16.
 */
public interface UserInfoDao {
    public Long insert(UserInfoDmo ui) ;

    public UserInfoDmo get(int userId) ;

    public UserInfoDmo getUserInfo(Long userId) ;

    public UserInfoDmo getUserInfo(String propertyName,Object arg);

    public List<UserInfoDmo> getUserInfoList() ;

    public int updateUserInfoStatus(long userId, String status) ;

    public int updateUserInfoUserName(long userId, String userName) ;
}
