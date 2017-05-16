package com.liuyao.dao.impl;

import com.liuyao.dao.intf.UserInfoDao;
import com.liuyao.dmo.UserInfoDmo;
import com.liuyao.dmo.UserLoginDmo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.hibernate.criterion.Restrictions.eq;

/**
 * Created by xiaoliu on 2017/5/12.
 */
@Repository
public class UserInfoDaoImpl implements UserInfoDao {

    @Autowired
    private SessionFactory sf;

    public Long insert(UserInfoDmo ui) {

        return (Long)sf.getCurrentSession().save(ui);
    }

    public UserInfoDmo get(int userId) {
        return  (UserInfoDmo) sf.getCurrentSession().load(UserInfoDmo.class,userId);
    }

    public UserInfoDmo getUserInfo(Long userId) {
        Session ss = sf.getCurrentSession();
        return (UserInfoDmo) ss.load(UserInfoDmo.class,userId);
    }

    /* 根据相关属性查询用户的实体 */
    public UserInfoDmo getUserInfo(String propertyName, Object arg) {
        Session ss = sf.getCurrentSession();
        Criteria c = ss.createCriteria(UserInfoDmo.class);
        c.add(Restrictions.eq(propertyName,arg));
        List<UserInfoDmo> dmos =  c.list();
        if(dmos.size() <= 0) {
            return null;
        }else {
            return dmos.get(0);
        }
    }

    /* 查询用户信息列表 */
    public List<UserInfoDmo> getUserInfoList() {
        Session ss = sf.getCurrentSession();
        List<UserInfoDmo> r = ss.createQuery("select U from UserInfoDmo U").list();

        return r;
    }

    public int updateUserInfoStatus(long userId, String status) {
        try {
            Session ss = sf.getCurrentSession();
            UserInfoDmo u = (UserInfoDmo) ss.load(UserInfoDmo.class, userId);
            u.setStatus(status);
            ss.saveOrUpdate(u);
            return 1;
        }catch (Exception e) {
            return -1;
        }
    }


    //更新用户的昵称，若更新失败，则返回-1，更新成功返回1
    public int updateUserInfoUserName(long userId, String userName) {
        try {
            Session ss = sf.getCurrentSession();
            UserInfoDmo u = (UserInfoDmo) ss.load(UserInfoDmo.class, userId);
            u.setUserName(userName);
            ss.saveOrUpdate(u);
            return 1;
        }catch (Exception e) {
            return -1;
        }
    }
}
