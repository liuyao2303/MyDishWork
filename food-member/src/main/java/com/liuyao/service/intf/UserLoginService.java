package com.liuyao.service.intf;

import com.liuyao.constant.Result;
import com.liuyao.dto.UserLoginDto;

/**
 * Created by xiaoliu on 2017/5/16.
 */
public interface UserLoginService {

    public Result loginCheck(String phone,String password) ;

    public Long addUserLoginInfo(UserLoginDto userLogin);

    public UserLoginDto getUserLoginInfo(Long userId) ;
}
