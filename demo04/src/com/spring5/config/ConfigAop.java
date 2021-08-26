package com.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 配制类(完全注解开发)
 * @author lichuang
 * @create 2021-08-25 16:24
 * @project_name spring5
 */
@Configuration
@ComponentScan(basePackages = {"com.spring5"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {
}
