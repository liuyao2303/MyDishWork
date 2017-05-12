package com.liuyao.dao;

import com.liuyao.dmo.UserInfoDmo;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xiaoliu on 2017/5/12.
 */
@Repository
public class UserInfoDao {

    @Autowired
    private SessionFactory sf;

    @Transactional
    public void insert(UserInfoDmo ui) {

        sf.getCurrentSession().save(ui);
    }

    public UserInfoDmo get(int userId) {
        return  (UserInfoDmo) sf.getCurrentSession().load(UserInfoDmo.class,userId);
    }

}
