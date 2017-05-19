package com.liuyao.service.impl;

import com.ccq.framework.annotation.ServiceTrace;
import com.ccq.framework.lang.Result;
import com.liuyao.constants.DishStatus;
import com.liuyao.dao.intf.CatagoryInfoDao;
import com.liuyao.dao.intf.DishDetailInfoDao;
import com.liuyao.dmo.CatagoryInfoDmo;
import com.liuyao.dto.CatagoryInfoDto;
import com.liuyao.dto.ChangCataOrderDto;
import com.liuyao.service.intf.CatagoryInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xiaoliu on 2017/5/18.
 */
@Component
@ServiceTrace
@Transactional
public class CatagoryInfoServiceImpl implements CatagoryInfoService{

    @Autowired
    private DishDetailInfoDao dishDetailInfoDao;

    @Autowired
    private CatagoryInfoDao catagoryInfoDao;


    /**
     * 增加一条新的种类信息
     *
     * @param title, catagoryId
     * @return
     */
    public Result addCatagory(String title) {
        CatagoryInfoDmo cata = getFreshCatagory();
        cata.setTitle(title);
        catagoryInfoDao.insert(cata);
        return new Result(true,"insert success!");
    }

    /**
     * 获取所有的种类信息
     *
     * @return List<CatagoryInfoDto>
     */
    public List<CatagoryInfoDto> getCatagoryList() {
        List<CatagoryInfoDto> dtoList =
                new ArrayList<CatagoryInfoDto>();
        List<CatagoryInfoDmo> cataList =
                catagoryInfoDao.getCatagoryInfoList(DishStatus.DISH_STATUS_USING);

        for(CatagoryInfoDmo dmo : cataList) {
            CatagoryInfoDto dto = new CatagoryInfoDto();
            BeanUtils.copyProperties(dmo,dto);
            dtoList.add(dto);
        }
        return dtoList;
    }

    public CatagoryInfoDto getCatagoryById(Long catagoryId) {
        CatagoryInfoDto dto = new CatagoryInfoDto();
        BeanUtils.copyProperties(
                catagoryInfoDao.getCatagoryInfo(catagoryId),dto);
        return dto;
    }

    /**
     * 保存顺序
     *
     * @param orders
     */
    public void saveOrder(List<ChangCataOrderDto> orders) {

    }

    /**
     *  改变种类的标题信息
     *
     * @param catagoryId
     * @param title
     * @return com.ccq.framework.lang.Result
     */
    public Result alterCatagoryTitle(Long catagoryId, String title) {
        CatagoryInfoDmo dmo = load(catagoryId);
        dmo.setTitle(title);
        catagoryInfoDao.update(dmo);
        return new Result(true,"OK");
    }

    /**
     * 下架
     *
     * @param catagoryId
     * @return
     */
    public Result downDesk(Long catagoryId) {
        CatagoryInfoDmo dmo = load(catagoryId);
        dmo.setStatus(DishStatus.DISH_STATUS_UNSHELVE);
        catagoryInfoDao.update(dmo);
        return new Result(true,"OK");
    }


    /**
     * 上架
     *
     * @param catagoryId
     * @return
     */
    public Result upDesk(Long catagoryId) {
        CatagoryInfoDmo dmo = load(catagoryId);
        dmo.setStatus(DishStatus.DISH_STATUS_USING);
        catagoryInfoDao.update(dmo);
        return new Result(true,"OK");
    }

    /**
     * 删除
     *
     * @param catagoryId
     * @return
     */
    public Result removeCatagory(Long catagoryId) {
        CatagoryInfoDmo dmo = load(catagoryId);
        dmo.setStatus(DishStatus.DISH_STATUS_DELETE);
        catagoryInfoDao.update(dmo);
        return new Result(true,"OK");
    }

    /* 根据cataId来加载种类信息实体 */
    private CatagoryInfoDmo load(Long cataId) {
        return catagoryInfoDao.getCatagoryInfo(cataId);
    }

    /* 为插入一条新的信息进行校验 */
    private Result verifyCatagoryTitle(String title) {
        if(StringUtils.isEmpty(title) || title.length() > 64) {
            return new Result(false,"Title Verify failed");
        }else
            return new Result(true,"ok");
    }

    private CatagoryInfoDmo getFreshCatagory() {
        CatagoryInfoDmo dmo = new CatagoryInfoDmo();
        dmo.setCreateTime(new Date());
        dmo.setStatus(DishStatus.DISH_STATUS_REVIEWING);
        return dmo;
    }
}
