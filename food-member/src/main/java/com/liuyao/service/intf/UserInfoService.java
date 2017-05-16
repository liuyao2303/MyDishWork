package com.liuyao.service.intf;

import com.liuyao.dmo.UserLoginDmo;
import com.liuyao.dto.UserInfoDto;
import com.liuyao.dto.UserLoginDto;

import java.util.List;

public interface UserInfoService {
    /* 添加接口 */
    public Long addUserInfo(UserInfoDto user);

    public Long addUserLoginInfo(UserLoginDto userLogin);

    /* 查询接口 */
    public UserInfoDto getUserInfo(Long userId) ;

    public List<UserInfoDto> getAllUserInfo();

    public UserLoginDto getUserLoginInfo(Long userId) ;

    public int updateUserInfoStatus(long userId, String status) ;

    public int updateUserInfoName(long userId, String userName);
}
