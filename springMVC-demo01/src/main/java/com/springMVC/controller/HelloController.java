package com.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lichuang
 * @create 2021-08-28 16:47
 * @project_name springMVC
 */
@Controller
public class HelloController {

    // "/“-->WEB-INF/templates/index.html
    @RequestMapping("/")
    public String index(){
        // 返回视图名称
        return "index";
    }

    @RequestMapping("/target")
    public String toTarget(){
        return "target";
    }

}
