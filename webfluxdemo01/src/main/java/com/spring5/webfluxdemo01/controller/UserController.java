package com.spring5.webfluxdemo01.controller;

import com.spring5.webfluxdemo01.entity.User;
import com.spring5.webfluxdemo01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author lichuang
 * @create 2021-08-27 0:00
 * @project_name spring5
 */
@RestController
public class UserController {

    // 注入Service
    @Autowired
    private UserService userService;

    /**
     * id查询
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public Mono<User> getUserId(@PathVariable int id){
        return userService.getUserById(id);
    }

    /**
     * 获取所有用户
     * @return
     */
    @GetMapping("/user")
    public Flux<User> getUsers(){
        return userService.getAllUser();
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @GetMapping("/savaUser")
    public Mono<Void> saveUser(@RequestBody User user){
        Mono<User> userMono = Mono.just(user);
        return userService.saveUserInfo(userMono);
    }
}
