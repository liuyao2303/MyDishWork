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
        return mv;
    }
}
