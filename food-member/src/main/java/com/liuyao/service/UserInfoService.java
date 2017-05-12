package com.liuyao.service;

import com.liuyao.dao.UserInfoDao;
import com.liuyao.dto.UserInfoDto;
import com.liuyao.dmo.UserInfoDmo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xiaoliu on 2017/5/12.
 */
@Service
public class UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    public boolean addUser(UserInfoDto ui) {
        if(ui.getUserName() == null || ui.getUserName().equals("")) {
            return false;
        }

        UserInfoDmo u = new UserInfoDmo();
        BeanUtils.copyProperties(ui,u);
        u.setStatus("00");
        userInfoDao.insert(u);
        return true;
    }

    @Transactional
    public UserInfoDto loadUserInfo(int userId) {
        UserInfoDmo ui = userInfoDao.get(userId);
        UserInfoDto dto = new UserInfoDto();
        BeanUtils.copyProperties(ui,dto);
        return dto;
    }
}
