package com.liuyao.dao.impl;

import com.liuyao.dao.intf.UserLoginDao;
import com.liuyao.dmo.UserLoginDmo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xiaoliu on 2017/5/16.
 */
@Repository
public class UserLoginDaoImpl implements UserLoginDao{

    @Autowired
    private SessionFactory sf;

    public Long addUserLoginInfo(UserLoginDmo loginDmo) {

        return (Long) sf.getCurrentSession().save(loginDmo);
    }


    /* 根据用户id，查询用户的登陆信息表 */
    public UserLoginDmo getUserLoginInfo(Long userId) {
        try {
            Session ss = sf.getCurrentSession();
            Criteria c = ss.createCriteria(UserLoginDmo.class);
            c.add(Restrictions.eq("userId",userId));
            List r = c.list();
            if(r.size() < 1) {
                return null;
            }else {
                UserLoginDmo dmo = (UserLoginDmo) r.get(0);
                return dmo;
            }
        }catch (Exception e) {
            return null;
        }
    }
}
