package com.liuyao.dao.impl;

import com.ccq.framework.exception.AppException;
import com.liuyao.constants.DishStatus;
import com.liuyao.dao.intf.DishDetailInfoDao;
import com.liuyao.dmo.CatagoryInfoDmo;
import com.liuyao.dmo.DishDetailInfoDmo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by xiaoliu on 2017/5/18.
 */
public class DishDetailDaoImpl implements DishDetailInfoDao{
    @Autowired
    private SessionFactory sf;

    /* 插入的时候需要先看看所属的种类是不是真的存在 */
    public Long insert(DishDetailInfoDmo dish) {
        Session ss = sf.getCurrentSession();
        CatagoryInfoDmo cata = (CatagoryInfoDmo) ss.load(CatagoryInfoDmo.class,dish.getCatagoryId());
        if(cata == null) {
            throw new AppException(false,"catagory not exist！");
        }
        return (Long) ss.save(dish);
    }

    public List<DishDetailInfoDmo> getDishDetailList(DishDetailInfoDmo con) {
        Criteria c = sf.getCurrentSession().createCriteria(DishDetailInfoDmo.class);
        if(con.getCatagoryId() != null) {
            c.add(Restrictions.eq("catagoryId",con.getCatagoryId()));
        }
        if(con.getDishStatus() != null) {
            c.add(Restrictions.eq("dishStatus",con.getDishStatus()));
        }
        return c.list();
    }

    public DishDetailInfoDmo getDishInfoDmo(Long id) {
        return (DishDetailInfoDmo) sf.getCurrentSession()
                .load(DishDetailInfoDmo.class,id);
    }

    public void update(DishDetailInfoDmo entity) {
        Session ss = sf.getCurrentSession();
        DishDetailInfoDmo dmo = (DishDetailInfoDmo) ss.
                load(DishDetailInfoDmo.class,entity.getCatagoryId());
        BeanUtils.copyProperties(entity,dmo);
        ss.saveOrUpdate(dmo);
    }

    public void delete(Long id) {
        Session ss = sf.getCurrentSession();
        DishDetailInfoDmo dmo = (DishDetailInfoDmo) ss.load(DishDetailInfoDmo.class,id);
        dmo.setDishStatus(DishStatus.DISH_STATUS_DELETE);
        update(dmo);
    }
}
