package com.liuyao.service.impl;

import com.ccq.framework.annotation.ServiceTrace;
import com.ccq.framework.lang.Result;
import com.liuyao.dao.intf.DishDetailInfoDao;
import com.liuyao.dmo.DishDetailInfoDmo;
import com.liuyao.dto.DishDetailInfoBuildDto;
import com.liuyao.dto.DishDetailInfoDto;
import com.liuyao.service.intf.DishDetailInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoliu on 2017/5/18.
 */
@Repository("DishDetailInfoService")
@ServiceTrace
public class DishDetailInfoServiceImpl implements DishDetailInfoService {

    @Autowired
    private DishDetailInfoDao dishDetailInfoDao;

    public List<DishDetailInfoDto> getDishDetails(Long cataId) {

        List<DishDetailInfoDto> data = new ArrayList<DishDetailInfoDto>();
        DishDetailInfoDmo con = new DishDetailInfoDmo();
        con.setCatagoryId(cataId);
        List<DishDetailInfoDmo> r =  dishDetailInfoDao
                .getDishDetailList(con);

        for(DishDetailInfoDmo dmo : r) {
            DishDetailInfoDto dto = new DishDetailInfoDto();
            BeanUtils.copyProperties(dmo,dto);
        }
        return data;
    }

    public Result addDish(DishDetailInfoBuildDto data) {
        return null;
    }

    public DishDetailInfoDto getDishDetail(Long dishId) {
        return null;
    }

    public Result updateTitle(Long dishId, String title) {
        return null;
    }

    public Result updateLogo(Long dishId, String logo) {
        return null;
    }

    public Result updatePrice(Long dishId, double price) {
        return null;
    }

    public Result updateDescription(Long dishId, String desc) {
        return null;
    }

    public Result updateStorge(Long dishId, int count) {
        return null;
    }

    public Result changCatagory(Long dishId, Long catagoryId) {
        return null;
    }

    public Result downDesk(Long dishId) {
        return null;
    }

    public Result upDesk(Long dishId) {
        return null;
    }

    public Result removeDish(Long dishId) {
        return null;
    }

    public Result stopSell(Long dishId) {
        return null;
    }
}
