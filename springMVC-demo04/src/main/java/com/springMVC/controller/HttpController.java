package com.springMVC.controller;

import com.springMVC.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author lichuang
 * @Create 2021-09-01 16:47
 * @Project_Name springMVC
 */
@Controller
public class HttpController {

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody){
        System.out.println("requestBody:" + requestBody);
        return "success";
    }

    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity){
        // 当前requestEntity表示整个请求报文的信息
        System.out.println("请求头：" + requestEntity.getHeaders());
        System.out.println("请求体：" + requestEntity.getBody());
        return "success";
    }

    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello,response");
    }

    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody(){
        return "success"; // 响应到浏览器的响应体,并不是网页
    }

    @RequestMapping("testResponseUser")
    @ResponseBody // 将Java对象直接作为控制器方法的返回值返回，就会自动转换为Json格式的字符串
    public User testResponseUser(){
        return new User(1001,"admin","123456",23,"男"); // 需要导入JSON的相关依赖jackson
    }

    @RequestMapping("/testAjax")
    @ResponseBody
    public String testAjax(String username,String password){
        System.out.println(username + "," + password);
        return "hello,ajax";
    }

}
