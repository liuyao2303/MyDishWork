package com.liuyao.dao.impl;

import com.ccq.framework.exception.AppException;
import com.liuyao.constant.Result;
import com.liuyao.dao.intf.UserLoginDao;
import com.liuyao.dmo.UserInfoDmo;
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
            /* 重新抛出运行时包装一场，保证当前的痴线错误的事物能够准确回滚 */
            throw new AppException(e);
        }
    }

    /* 根据用户id，查询用户的登陆信息表 */
    @Deprecated
    public UserLoginDmo getUserLoginInfo(String userName) {
        try {
            Session ss = sf.getCurrentSession();
            Criteria c = ss.createCriteria(UserInfoDmo.class);
            c.add(Restrictions.eq("userName",userName));
            List r = c.list();
            if(r.size() < 1) {
                return null;
            }else {
                UserInfoDmo dmo = (UserInfoDmo) r.get(0);
                return null;
            }
        }catch (Exception e) {
            /* 重新抛出运行时包装一场，保证当前的痴线错误的事物能够准确回滚 */
            throw new AppException(e);
        }
    }

    /* 更新 用户密码信息 */
    public Long updatePassword(Long userId, String pwd) {
        Session ss = sf.getCurrentSession();

        UserLoginDmo dmo = getUserLoginByProperty("userId",userId);

        if(dmo == null) {
            throw new AppException(false,"该用户不存在！");
        }

        UserLoginDmo userLogin = (UserLoginDmo) ss.load(UserLoginDmo.class,dmo.getId());
        if(userLogin == null) {
            return -1L;
        }else {
            userLogin.setPassword(pwd);
            try {
                ss.saveOrUpdate(userLogin);
            }catch (Exception e) {
                throw new AppException(e);
            }
            return 1L;
        }
    }


    /*tools*/
    public UserLoginDmo getUserLoginByProperty(String prop,Object arg) {
        try {
            Session ss = sf.getCurrentSession();
            Criteria c = ss.createCriteria(UserLoginDmo.class);
            c.add(Restrictions.eq(prop,arg));
            List<UserLoginDmo> dmos = c.list();
            if(dmos.size() < 1) {
                return null;
            }else {
                UserLoginDmo dmo = (UserLoginDmo) dmos.get(0);
                return dmo;
            }
        }catch (Exception e) {
            /* 重新抛出运行时包装一场，保证当前的痴线错误的事物能够准确回滚 */
            throw new AppException(e);
        }
    }
}
