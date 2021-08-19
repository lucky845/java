package com.book.filter;

import com.book.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * 实现事务统一try-catch管理
 * @author lichuang
 * @create 2021-08-19 20:36
 * @project_name javaWEB
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try {
            filterChain.doFilter(servletRequest,servletResponse);

            JdbcUtils.commitAndClose(); // 提交事务

        } catch (Exception e) {
            JdbcUtils.rollbackAndClose(); // 回滚事务
            e.printStackTrace();
            throw new RuntimeException(e); // 把异常抛给Tomcat服务器统一处理,显示错误页面
        }

    }

    @Override
    public void destroy() {

    }
}
