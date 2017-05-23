package com.liuyao.controller;

import com.ccq.framework.lang.Result;
import com.liuyao.dmo.DishDetailInfoDmo;
import com.liuyao.dto.DishDetailInfoDto;
import com.liuyao.service.intf.DishDetailInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xiaoliu on 2017/5/19.
 */
@Controller
@RequestMapping("/dish")
public class DishController {

    @Autowired
    private DishDetailInfoService dishDetailInfoService;

    @ResponseBody
    @RequestMapping("/cata/{id}")
    public List<DishDetailInfoDto> getDishDetails(@PathVariable("id") Long id) {
        return dishDetailInfoService.getDishDetails(id);
    }

    @ResponseBody
    @RequestMapping("/detail/{id}")
    public DishDetailInfoDto getDishDetail(@PathVariable("id") Long id) {
        DishDetailInfoDto data = dishDetailInfoService.getDishDetail(id);
        if(data == null)
            return new DishDetailInfoDto();
        else
            return data;
    }

    @ResponseBody
    @RequestMapping(value = "/dish/updatetitle/{id}",method = RequestMethod.POST)
    public Result updateTitle(@PathVariable("id") Long id,String title) {
        return dishDetailInfoService.updateTitle(id,title);
    }

//    @ResponseBody
//    @RequestMapping("test")
//    public Result testTwo() {
//        return dishDetailInfoService.testInsertTwo();
//    }
}
