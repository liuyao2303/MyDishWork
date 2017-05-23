package com.liuyao.service.impl;

import com.ccq.framework.annotation.ServiceTrace;
import com.ccq.framework.exception.AppException;
import com.ccq.framework.lang.Result;
import com.liuyao.constants.DishStatus;
import com.liuyao.dao.intf.CatagoryInfoDao;
import com.liuyao.dao.intf.DishDetailInfoDao;
import com.liuyao.dmo.CatagoryInfoDmo;
import com.liuyao.dmo.DishDetailInfoDmo;
import com.liuyao.dto.DishDetailInfoBuildDto;
import com.liuyao.dto.DishDetailInfoDto;
import com.liuyao.service.intf.DishDetailInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xiaoliu on 2017/5/18.
 */
@Repository("DishDetailInfoService")
@ServiceTrace           //对业务层出现的一场进行封装，统一包装，注意oeder，必须包含事务的异常
@Transactional
public class DishDetailInfoServiceImpl implements DishDetailInfoService {

    public static int MAX_TITLE_LEN = 27;
    public static int MIN_TITLE_LEN = 3;

    @Autowired
    private CatagoryInfoDao catagoryInfoDao;

    @Autowired
    private DishDetailInfoDao dishDetailInfoDao;


//    public Result testInsertTwo() {
//
//        CatagoryInfoDmo cataDmo = new CatagoryInfoDmo();
//        cataDmo.setTitle("sdsd");
//        cataDmo.setStatus("00");
//        cataDmo.setCreateTime(new Date());
//        cataDmo.setOrder(1L);
//        catagoryInfoDao.insert(cataDmo);
//
//        //throw new AppException(false,"false,食物没有回滚");
//        return new Result(true,"Success!");
//    }

    /* 获取该种类的所有二级菜单信息 */
    public List<DishDetailInfoDto> getDishDetails(Long cataId) {

        List<DishDetailInfoDto> data = new ArrayList<DishDetailInfoDto>();
        DishDetailInfoDmo con = new DishDetailInfoDmo();
        con.setCatagoryId(cataId);

        //查询正在使用的品类信息
        con.setDishStatus(DishStatus.DISH_STATUS_USING);
        List<DishDetailInfoDmo> r =  dishDetailInfoDao
                .getDishDetailList(con);

        for(DishDetailInfoDmo dmo : r) {
            DishDetailInfoDto dto = new DishDetailInfoDto();
            BeanUtils.copyProperties(dmo,dto);
            data.add(dto);
        }
        return data;
    }

    /**
     * 添加新的二级菜单
     * @param data
     * @return
     */
    public Result addDish(DishDetailInfoBuildDto data) {
        Result r = validate(data);
        if(!r.isSuccess()) {
            return r;
        }
        DishDetailInfoDmo dish = getFreshDish();
        BeanUtils.copyProperties(data,dish);
        dishDetailInfoDao.insert(dish);
        return new Result(false,"OK");
    }

    //TODO
    private Result validate(DishDetailInfoBuildDto data) {
        return null;
    }

    /* 获取默认的二级菜单 */
    private DishDetailInfoDmo getFreshDish() {
        DishDetailInfoDmo dish = new DishDetailInfoDmo();
        dish.setDishStatus(DishStatus.DISH_STATUS_USING);
        dish.setSoldCount(0L);
        dish.setUnitType("00");     //not used
        return dish;
    }

    /* 查询不要用load，使用Criteria查询 */
    public DishDetailInfoDto getDishDetail(Long dishId) {
        if(dishId < 1) {
            throw new AppException(false,"id illeagel!");
        }
        DishDetailInfoDmo dish = dishDetailInfoDao.getDishInfoDmo(dishId);
        if(dish == null) {
            return null;
        }
        DishDetailInfoDto data = new DishDetailInfoDto();
        BeanUtils.copyProperties(dish,data);
        return data;
    }

    /**
     * 更新标题
     * @param dishId
     * @param title
     * @return
     */
    public Result updateTitle(Long dishId, String title) {
        Result r = validateTitle(title);
        if(!r.isSuccess()) {
            return r;
        }
        //TODO
        r = checkTitleExists(title);

        DishDetailInfoDmo dish = checkExists(dishId);

        if(dish == null)
            return new Result(false,"dish not exists");
        dish.setDishName(title);
        dishDetailInfoDao.update(dish);
        return new Result(true,"success!");
    }

    private DishDetailInfoDmo checkExists(Long dishId) {
        DishDetailInfoDmo dish = dishDetailInfoDao.getDishInfoDmo(dishId);
        if(dish == null) {
            throw new AppException(false,"所指定的二级菜单不存在！");
        }
        return dish;
    }

    /**
     * 判断是否存在相同的标题
     * @param title
     * @return
     */
    private Result checkTitleExists(String title) {
        DishDetailInfoDmo con = new DishDetailInfoDmo();
        con.setDishName(title);

        List<DishDetailInfoDmo> data = dishDetailInfoDao.getDishDetailList(con);

        if(data.size() > 0) {
            return new Result(false,"该标题已存在!");
        }
        return new Result(true,"OK");
    }

    /**
     * 验证标题是否满足要求
     * @param title
     * @return
     */
    public Result validateTitle(String title) {
        if(title.length() > MAX_TITLE_LEN || title.length() < MIN_TITLE_LEN) {
            return new Result(false,"标题长度不符合要求!");
        }else
            return new Result(true,"ok");
    }


    /**
     * 更新logo
     * @param dishId
     * @param logo
     * @return
     */
    public Result updateLogo(Long dishId, String logo) {
        DishDetailInfoDmo dish = checkExists(dishId);
        if(dish == null)
            return new Result(false,"dish not exists");
        dish.setPic(logo);
        dishDetailInfoDao.update(dish);
        return new Result(true,"success!");
    }

    public Result updatePrice(Long dishId, double price) {
        DishDetailInfoDmo dish = checkExists(dishId);
        if(dish == null)
            return new Result(false,"dish not exists");
        dish.setPrice(price);
        dishDetailInfoDao.update(dish);
        return new Result(true,"success!");
    }

    public Result updateDescription(Long dishId, String desc) {
        DishDetailInfoDmo dish = checkExists(dishId);
        if(dish == null)
            return new Result(false,"dish not exists");
        dish.setDescription(desc);
        dishDetailInfoDao.update(dish);
        return new Result(true,"success!");
    }

    public Result updateStorge(Long dishId, int count) {
        DishDetailInfoDmo dish = checkExists(dishId);
        if(dish == null)
            return new Result(false,"dish not exists");
        dish.setStorage(new Long(count));
        dishDetailInfoDao.update(dish);
        return new Result(true,"success!");
    }

    public Result changCatagory(Long dishId, Long catagoryId) {
        DishDetailInfoDmo dish = checkExists(dishId);
        if(dish == null)
            return new Result(false,"dish not exists");

        //TODO 需要判断一级菜单是否存在
        CatagoryInfoDmo dmo = catagoryInfoDao.getCatagoryInfo(catagoryId);
        if(dmo == null)
            return new Result(false,"该一级菜单已经失效");

        dish.setCatagoryId(catagoryId);
        dishDetailInfoDao.update(dish);
        return new Result(true,"success!");
    }

    public Result downDesk(Long dishId) {
        DishDetailInfoDmo dish = checkExists(dishId);
        if(dish == null)
            return new Result(false,"dish not exists");
        dish.setDishStatus(DishStatus.DISH_STATUS_UNSHELVE);
        dishDetailInfoDao.update(dish);
        return new Result(true,"success!");
    }

    public Result upDesk(Long dishId) {
        DishDetailInfoDmo dish = checkExists(dishId);
        if(dish == null)
            return new Result(false,"dish not exists");
        dish.setDishStatus(DishStatus.DISH_STATUS_USING);
        dishDetailInfoDao.update(dish);
        return new Result(true,"success!");
    }

    public Result removeDish(Long dishId) {
        DishDetailInfoDmo dish = checkExists(dishId);
        if(dish == null)
            return new Result(false,"dish not exists");
        dish.setDishStatus(DishStatus.DISH_STATUS_DELETE);
        dishDetailInfoDao.update(dish);
        return new Result(true,"success!");
    }

    /**
     * 停售
     * @param dishId
     * @return
     */
    public Result stopSell(Long dishId) {
        DishDetailInfoDmo dish = checkExists(dishId);
        if(dish == null)
            return new Result(false,"dish not exists");
        dish.setDishStatus(DishStatus.DISH_STATUS_STOPSELL);
        dishDetailInfoDao.update(dish);
        return new Result(true,"success!");
    }
}
