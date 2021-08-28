package com.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author lichuang
 * @Create 2021-08-28 17:58
 * @Project_Name springMVC
 */
@Controller
//@RequestMapping("/hello") // 设置初始路径
public class RequestMappingController {

    @RequestMapping(value = {"/testRequestMapping", "/test"})
    public String success() {
        return "success";
    }

}
