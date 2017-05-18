package com.liuyao;

import com.liuyao.constants.DishStatus;
import com.liuyao.dao.intf.CatagoryInfoDao;
import com.liuyao.dmo.CatagoryInfoDmo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by xiaoliu on 2017/5/18.
 */

@ContextConfiguration(locations = "classpath:application-db.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CatagoryDaoTest {

    @Autowired
    private CatagoryInfoDao dao;

    @Test
    public void testInsert() {
        CatagoryInfoDmo dmo = new CatagoryInfoDmo();
        dmo.setStatus(DishStatus.DISH_STATUS_REVIEWING);
        dmo.setCreateTime(new Date());
        dmo.setOrder(10012L);
        dmo.setTitle("美味单点");

        Long id = dao.insert(dmo);
        System.out.println("插入的数据ID为：  " + id);
    }

    @Test
    public void testSelect() {
        CatagoryInfoDmo dmo = dao.getCatagoryInfo(1L);
        System.out.println(dmo);
    }

    @Test
    public void testSelectList() {
        List<CatagoryInfoDmo> list = dao.getCatagoryInfoList(DishStatus.DISH_STATUS_REVIEWING);
        for(CatagoryInfoDmo dmo : list) {
            System.out.println(dmo);
        }
    }

    @Test
    public void testSelectListByName() {
        List<CatagoryInfoDmo> list = dao.getCatagoryInfo("status",DishStatus.DISH_STATUS_REVIEWING);
        for(CatagoryInfoDmo dmo : list) {
            System.out.println(dmo);
        }
    }

}
