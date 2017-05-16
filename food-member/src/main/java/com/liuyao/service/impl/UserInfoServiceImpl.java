package com.liuyao.service.impl;

import com.liuyao.dao.intf.UserInfoDao;
import com.liuyao.dmo.UserInfoDmo;
import com.liuyao.dmo.UserLoginDmo;
import com.liuyao.dto.UserInfoDto;
import com.liuyao.dto.UserLoginDto;
import com.liuyao.service.intf.UserInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoliu on 2017/5/12.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired
    private UserInfoDao userInfoDao;

    /* 添加新的额用户信息，不包含用户的账号信息 */
    @Transactional
    public Long addUserInfo(UserInfoDto user) {
        UserInfoDmo userDmo = new UserInfoDmo();
        BeanUtils.copyProperties(user,userDmo);  //属性拷贝
        return userInfoDao.insert(userDmo);
    }

    @Transactional
    public UserInfoDto getUserInfo(Long userId) {
        UserInfoDmo dmo = userInfoDao.getUserInfo(userId);
        UserInfoDto dto = new UserInfoDto();
        BeanUtils.copyProperties(dmo,dto);
        return dto;
    }

    /*  根据用户的电话号码查询用户的账户信息 */
    @Transactional
    public UserInfoDto getUserInfo(String phone) {
        UserInfoDmo dmo = userInfoDao.getUserInfo("phoneNumber",phone);
        UserInfoDto dto = new UserInfoDto();
        BeanUtils.copyProperties(dmo,dto);
        return dto;
    }

    @Transactional
    public List<UserInfoDto> getAllUserInfo() {
        List<UserInfoDto> dtoList = new ArrayList();
        List<UserInfoDmo> dmoList = userInfoDao.getUserInfoList();
        for(UserInfoDmo dmo : dmoList) {
            UserInfoDto dto = new UserInfoDto();
            BeanUtils.copyProperties(dmo,dto);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Transactional
    public int updateUserInfoStatus(long userId, String status) {
        return userInfoDao.updateUserInfoStatus(userId,status);
    }

    @Transactional
    public int updateUserInfoName(long userId, String userName) {
        return userInfoDao.updateUserInfoUserName(userId,userName);
    }
}
