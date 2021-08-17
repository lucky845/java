package com.cookie.util;

import javax.servlet.http.Cookie;

/**
 * @author lichuang
 * @create 2021-08-17 15:40
 */
public class CookieUtils {

    /**
     * 查找指定名称的Cookie对象
     * @Author lichuang
     * @Date 2021/8/17 15:41
     * @param name
     * @param cookies
     * @return javax.servlet.http.Cookie
     */
    public static Cookie findCookie(String name,Cookie[] cookies){
        if(name == null || cookies == null || cookies.length == 0){
            return null;
        }

        for (Cookie cookie : cookies) {
            if(name.equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }

}
