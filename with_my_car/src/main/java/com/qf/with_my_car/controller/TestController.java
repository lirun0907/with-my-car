package com.qf.with_my_car.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("activity_list")
    public String activity_list(){
        return "activity_list";
    }
}
