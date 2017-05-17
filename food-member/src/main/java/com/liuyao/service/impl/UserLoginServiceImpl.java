package com.liuyao.service.impl;

import com.ccq.framework.annotation.ServiceTrace;
import com.ccq.framework.lang.Result;
import com.liuyao.dao.intf.UserInfoDao;
import com.liuyao.dao.intf.UserLoginDao;
import com.liuyao.dmo.UserInfoDmo;
import com.liuyao.dmo.UserLoginDmo;
import com.liuyao.dto.UserLoginDto;
import com.liuyao.service.intf.UserInfoService;
import com.liuyao.service.intf.UserLoginService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xiaoliu on 2017/5/16.
 */
@Component
@ServiceTrace
public class UserLoginServiceImpl implements UserLoginService{

    @Autowired
    private UserLoginDao userLoginDao;

    @Autowired
    private UserInfoDao userInfoDao;

    /* 根据用户的手机号和密码来验证用户的身份信息 */
    @Transactional
    public Result loginCheck(String phone, String password) {
        UserInfoDmo dmo = userInfoDao.getUserInfo("phoneNumber",phone);    //根据电话号码来查询用户的账户信息
        UserLoginDmo login = userLoginDao.getUserLoginInfo(dmo.getUserId());
        if(login == null) {
            return new Result(false,"phone is wrone!");
        }else if(login.getPassword().equals(password)) {
            return new Result(true,"login success!");
        }else {
            return new Result(false,"password incorrect!");
        }
    }

    /* 插入用户的账户信息 */
    @Transactional
    public Long addUserLoginInfo(UserLoginDto userLogin) {

        /*dto传输对象中的密码是明文，需要进行MD5，才能保存在数据库中*/
        String pwd = userLogin.getPassword();
        userLogin.setPassword(DigestUtils.md5Hex(pwd));

        UserLoginDmo loginDmo = new UserLoginDmo();
        BeanUtils.copyProperties(userLogin,loginDmo);
        return userLoginDao.addUserLoginInfo(loginDmo);
    }

    @Transactional
    public UserLoginDto getUserLoginInfo(Long userId) {
        UserLoginDto dto = new UserLoginDto();
        UserLoginDmo dmo = userLoginDao.getUserLoginInfo(userId);
        if(dmo == null) {
            return null;
        }
        BeanUtils.copyProperties(dmo,dto);
        return dto;
    }

    /* 根据用户id，来更改用户密码 */
    @Transactional() //需要设置事物的隔离级别
    public Result alterPassword(Long userId, String pwd) {

        UserLoginDmo dmo = userLoginDao.getUserLoginInfo(userId);
        Long r = userLoginDao.updatePassword(userId,DigestUtils.md5Hex(pwd));
        if(r == 1) {
            return new Result(true,"ok!");
        }else
            return new Result(false,"修改失败");
    }

    /* 根据用户名来更改用户密码 */
    @Transactional
    public Result alterPassword(String userName, String pwd) {
        return null;
    }
}
