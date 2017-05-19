package com.liuyao.controller;

import com.liuyao.dmo.DishDetailInfoDmo;
import com.liuyao.dto.DishDetailInfoDto;
import com.liuyao.service.intf.DishDetailInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @RequestMapping("{id}")
    public List<DishDetailInfoDto> getDishDetail(@PathVariable("id") Long id) {
        return dishDetailInfoService.getDishDetails(id);
    }
//    @ResponseBody
//    @RequestMapping("/detail")
//    public List<DishDetailInfoDto> getDishDetail() {
//        return dishDetailInfoService.getDishDetails(1L);
//    }
}
