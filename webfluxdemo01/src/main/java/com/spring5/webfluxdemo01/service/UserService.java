package com.spring5.webfluxdemo01.service;

import com.spring5.webfluxdemo01.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 用户操作的接口
 * @author lichuang
 * @create 2021-08-26 23:43
 * @project_name spring5
 */
public interface UserService {
    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    Mono<User> getUserById(int id);

    /**
     * 查询所有用户
     * @return
     */
    Flux<User> getAllUser();

    /**
     * 添加用户
     * @param userMono
     * @return
     */
    Mono<Void> saveUserInfo(Mono<User> userMono);

}
