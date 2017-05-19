package com.liuyao.service.intf;

import com.ccq.framework.lang.Result;
import com.liuyao.dto.DishDetailInfoBuildDto;
import com.liuyao.dto.DishDetailInfoDto;
import com.sun.org.apache.regexp.internal.RE;

import java.util.List;

/**
 * Created by xiaoliu on 2017/5/18.
 */
public interface DishDetailInfoService {

    /* 根据分类id查询二级菜单信息 */
    public List<DishDetailInfoDto> getDishDetails(Long cataId) ;

    /* 插入一条新的二级菜单信息 */
    public Result addDish(DishDetailInfoBuildDto data) ;

    /* 根据Id查询 */
    public DishDetailInfoDto getDishDetail(Long dishId) ;

    public Result updateTitle(Long dishId,String title) ;

    public Result updateLogo(Long dishId, String logo) ;

    public Result updatePrice(Long dishId, double price) ;

    public Result updateDescription(Long dishId, String desc) ;

    public Result updateStorge(Long dishId,int count) ;

    public Result changCatagory(Long dishId, Long catagoryId) ;

    public Result downDesk(Long dishId) ;

    public Result upDesk(Long dishId) ;

    public Result removeDish(Long dishId);

    public Result stopSell(Long dishId) ;
}
