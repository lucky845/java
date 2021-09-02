package com.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author lichuang
 * @Create 2021-08-29 20:34
 * @Project_Name springMVC
 */
@Controller
public class JspController {

    @RequestMapping("/success")
    public String success(){
        return "success";
    }

}
