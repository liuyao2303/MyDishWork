package com.liuyao.controller;

import com.liuyao.dto.CatagoryInfoDto;
import com.liuyao.service.intf.CatagoryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by xiaoliu on 2017/5/19.
 */
@Controller
@RequestMapping("/catagory/")
public class CatagoryIController {

    @Autowired
    private CatagoryInfoService catagoryInfoService;

    @RequestMapping("list")
    @ResponseBody
    public List<CatagoryInfoDto> getAll() {
        return catagoryInfoService.getCatagoryList();
    }


}
