package com.liuyao.dao.impl;

import com.liuyao.constants.DishStatus;
import com.liuyao.dao.intf.CatagoryInfoDao;
import com.liuyao.dmo.CatagoryInfoDmo;
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
@Repository("catagoryInfoDao")
//@Transactional        //dao层一般为原子方法，事物需要在业务层加，表示一个业务的原子性
public class CatagoryInfoDaoImpl implements CatagoryInfoDao{

    @Autowired
    private SessionFactory sf;

    /* 插入一条种类信息，字段校验在service端完成，不在dao端校验 */
    public Long insert(CatagoryInfoDmo cata) {

        return (Long) sf.getCurrentSession().save(cata);
    }

    /* 查询所有的种类列表 */
    public List<CatagoryInfoDmo> getCatagoryInfoList(String status) {
        Session ss = sf.getCurrentSession();
        return ss.createCriteria(CatagoryInfoDmo.class)
                .add(Restrictions
                        .eq("status",status)).list();
    }

    public CatagoryInfoDmo getCatagoryInfo(Long cataId) {
        Session ss = sf.getCurrentSession();
        Criteria c = ss.createCriteria(CatagoryInfoDmo.class);
        return (CatagoryInfoDmo) c.
                add(Restrictions.eq("catagoryId",cataId))
                .setMaxResults(1)
                .list()
                .get(0);
    }

    public List<CatagoryInfoDmo> getCatagoryInfo(String prosName, Object arg) {
        Session ss = sf.getCurrentSession();
        Criteria c = ss.createCriteria(CatagoryInfoDmo.class);
        return c.add(Restrictions.eq(prosName,arg))
                .list();

    }

    public void update(CatagoryInfoDmo cata) {
        Session ss = sf.getCurrentSession();
        CatagoryInfoDmo dmo = (CatagoryInfoDmo) ss.
                load(CatagoryInfoDmo.class,cata.getCatagoryId());
        BeanUtils.copyProperties(cata,dmo);
        ss.saveOrUpdate(dmo);
    }

    /* 采用软删除的方式，不是真正的删除，只是改变状态字段*/
    public void remove(Long cataId) {
        Session ss = sf.getCurrentSession();
        CatagoryInfoDmo dmo = (CatagoryInfoDmo) ss.load(CatagoryInfoDmo.class,cataId);
        dmo.setStatus(DishStatus.DISH_STATUS_DELETE);
        update(dmo);
    }
}
