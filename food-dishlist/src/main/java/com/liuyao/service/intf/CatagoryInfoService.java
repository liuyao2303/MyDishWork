package com.liuyao.service.intf;

import com.ccq.framework.annotation.ServiceTrace;
import com.ccq.framework.lang.Result;
import com.liuyao.dto.CatagoryInfoDto;
import com.liuyao.dto.ChangCataOrderDto;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xiaoliu on 2017/5/18.
 */
public interface CatagoryInfoService {

    /* 新增一条新的一级菜单 */
    public Result addCatagory(String title) ;

    /* 获取第一级菜单列表 */
    public List<CatagoryInfoDto> getCatagoryList() ;

    /* 根据种类Id来查询 */
    public CatagoryInfoDto getCatagoryById(Long catagoryId) ;

    /* 保存前端给的新的排序信息 */
    public void saveOrder (List<ChangCataOrderDto> orders);

    /* 改变种类名称 */
    public Result alterCatagoryTitle(Long catagoryId, String title) ;

    /* 下架摸个种类 */
    public Result downDesk(Long catagoryId) ;

    /* 上架某一个品类 */
    public Result upDesk(Long catagoryId) ;

    /* 移除一个品类 */
    public Result removeCatagory(Long catagoryId) ;

}
