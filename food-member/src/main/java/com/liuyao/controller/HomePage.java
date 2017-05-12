package com.liuyao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xiaoliu on 2017/5/10.
 */
@Controller
@RequestMapping(name = "/")
public class HomePage {

    @RequestMapping("")
    public ModelAndView home() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        UserInfoDto ui = new UserInfoDto();
        ui.setUserName("liuyao");
        ui.setAddr("南京市新模范马路66号，南京邮电大学");
        ui.setAge(24);
        ui.setSex("11");
        ui.setPhoneNumber("18252063065");
        userInfoService.addUser(ui);
        return mv;
    }

    @RequestMapping("userList")
    public ModelAndView userList() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("userList");
        UserInfoDto user = userInfoService.loadUserInfo(2);
        mv.addObject("user",user);
        return mv;
    }
}
