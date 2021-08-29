package com.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author lichuang
 * @Create 2021-08-28 17:30
 * @Project_Name springMVC
 */
@Controller
public class TestController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("param")
    public String param(){
        return "test_param";
    }

}
