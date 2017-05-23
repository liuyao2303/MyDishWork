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
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xiaoliu on 2017/5/18.
 */
@Repository("DishDetailInfoDao")
@Transactional
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

    /* 根据查询条件，查询DishList列表，一般只根据catagoryID和DishStatus来进行查询 */
    public List<DishDetailInfoDmo> getDishDetailList(DishDetailInfoDmo con) {
        Session ss = sf.getCurrentSession();
        Criteria c = sf.getCurrentSession().
                createCriteria(DishDetailInfoDmo.class);
        if(con.getCatagoryId() != null) {
            c.add(Restrictions.eq("catagoryId",con.getCatagoryId()));
        }
        if(con.getDescription() != null) {
            c.add(Restrictions.eq("description",con.getDescription()));
        }
        if(con.getDishName() != null) {
            c.add(Restrictions.eq("dishName",con.getDishName()));
        }
        if(con.getId() != null) {
            c.add(Restrictions.eq("id",con.getId()));
        }
        if(con.getDishStatus() != null) {
            c.add(Restrictions.eq("dishStatus",con.getDishStatus()));
        }
        List<DishDetailInfoDmo> data = c.list();
        return data;
    }

    /* 根据id来查询菜单信息 */
    public DishDetailInfoDmo getDishInfoDmo(Long id) {
        List<DishDetailInfoDmo> data = sf.getCurrentSession()
                .createCriteria(DishDetailInfoDmo.class)
                .add(Restrictions.eq("id",id))
                .setMaxResults(1)
                .list();
        if(data.size() < 1) return null;
        else return data.get(0);
    }

    /* 更新entity信息 */
    public void update(DishDetailInfoDmo entity) {
        Session ss = sf.getCurrentSession();
        DishDetailInfoDmo dmo = (DishDetailInfoDmo) ss.
                load(DishDetailInfoDmo.class,entity.getCatagoryId());
        if(dmo == null) {
            throw new AppException(false,"DishDetail not exists");
        }
        BeanUtils.copyProperties(entity,dmo);
        ss.saveOrUpdate(dmo);
    }

    /* 删除那个信息，软删除 */
    public void delete(Long id) {
        Session ss = sf.getCurrentSession();
        DishDetailInfoDmo dmo = (DishDetailInfoDmo) ss.load(DishDetailInfoDmo.class,id);

        /* 如果该部分的信息不存在，则抛出自定义一次，为了事物回滚，同时业务层的拦截器会做统一
        的封装 */
        if(dmo == null) {
            throw new AppException(false,"DishDetail not exists");
        }
        dmo.setDishStatus(DishStatus.DISH_STATUS_DELETE);
        update(dmo);
    }
}
