package com.liuyao.dao.intf;

import com.liuyao.dmo.DishDetailInfoDmo;

import java.util.List;

/**
 * Created by xiaoliu on 2017/5/18.
 */
public interface DishDetailInfoDao {
    /*插入一条菜单*/
    public Long insert(DishDetailInfoDmo dish);

    /* 根据查询条件来进行查询，查询的可能是但条件查询，也有可能是多条件联合查询 */
    public List<DishDetailInfoDmo> getDishDetailList(DishDetailInfoDmo con);

    public DishDetailInfoDmo getDishInfoDmo(Long id) ;

    public void update(DishDetailInfoDmo entity);

    public void delete(Long id);
}