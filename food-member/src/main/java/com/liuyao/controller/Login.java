package com.liuyao.controller;

import com.ccq.framework.lang.Result;
import com.liuyao.service.intf.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xiaoliu on 2017/5/16.
 */
@Controller
public class Login {

    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping("/index")
    public String index() {
        Result r = userLoginService.alterPassword(10L,"hello world");
        System.out.println(r);
        return "home";
    }
}
