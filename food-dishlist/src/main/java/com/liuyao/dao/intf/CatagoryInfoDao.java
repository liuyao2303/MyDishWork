package com.liuyao.dao.intf;

import com.liuyao.dmo.CatagoryInfoDmo;

import java.util.List;

/**
 * Created by xiaoliu on 2017/5/18.
 */
public interface CatagoryInfoDao {

    /* 插入一条新的种类信息，新增并返回主键 */
    public Long insert(CatagoryInfoDmo cata) ;

    /* 根据种类ID或者属性名称来进行查询 */
    public List<CatagoryInfoDmo> getCatagoryInfoList(String status);
    public CatagoryInfoDmo getCatagoryInfo(Long cataId) ;
    public List<CatagoryInfoDmo> getCatagoryInfo(String prosName,Object arg);

    /* 根据主键信息来进行更新 */
    public void update(CatagoryInfoDmo cata);

    /* 删除某一条信息，采用软删除 */
    public void remove(Long cataId) ;
}
