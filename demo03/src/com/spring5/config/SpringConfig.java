package com.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lichuang
 * @create 2021-08-24 19:59
 * @project_name spring5
 */
@Configuration // 作为配制类，代替xml文件配制
@ComponentScan(basePackages = "com.spring5")
public class SpringConfig {
}
