package com.liuyao.service.intf;

import com.liuyao.dmo.UserLoginDmo;
import com.liuyao.dto.UserInfoDto;
import com.liuyao.dto.UserLoginDto;

import java.util.List;

public interface UserInfoService {
    /* 添加接口 */
    public Long addUserInfo(UserInfoDto user);

    /* 查询接口 */
    public UserInfoDto getUserInfo(Long userId) ;

    /* 根据用户电话号码查询用户账户信息 */
    public UserInfoDto getUserInfo(String phone) ;

    public List<UserInfoDto> getAllUserInfo();

    public int updateUserInfoStatus(long userId, String status) ;

    public int updateUserInfoName(long userId, String userName);
}
