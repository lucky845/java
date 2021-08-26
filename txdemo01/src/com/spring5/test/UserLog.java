package com.spring5.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;

/**
 * @author lichuang
 * @create 2021-08-26 19:10
 * @project_name spring5
 */
public class UserLog {

    private static final Logger log = LoggerFactory.getLogger(UserLog.class);

    public static void main(String[] args){
        log.info("hello log4j2");
        log.warn("hello log4j2");
    }

}
