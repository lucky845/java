package com.cookie.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author lichuang
 * @create 2021-08-17 18:28
 */
public class SessionServlet extends BaseServlet{

    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建和获取Session会话对象
        HttpSession session = req.getSession();
        // 判断当前Session会话，是否是新建出来的
        boolean isNew = session.isNew();
        // 获取Session会话的唯一标识id
        String id = session.getId();

        resp.getWriter().write("得到的Session的id是: " + id + "<br/>");
        resp.getWriter().write("这个Session是否是新创建的: " + isNew + "<br/>");

    }

    /**
     * 往Session中保存数据
     * @Author lichuang
     * @Date 2021/8/17 19:05
     * @param req
     * @param resp
     * @return void
     */
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1","value1");
        resp.getWriter().write("已经往Session中保存了数据");
    }

    /**
     * 从Session获取数据
     * @Author lichuang
     * @Date 2021/8/17 19:05
     * @param req
     * @param resp
     * @return void
     */
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object attribute = req.getSession().getAttribute("key1");
        resp.getWriter().write("从Session中取出的key1数据是： " + attribute);
    }

    /**
     * Session会话的默认存活时长
     * @Author lichuang
     * @Date 2021/8/17 19:22
     * @param req
     * @param resp
     * @return void
     */
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取了Session会话的默认存活时长
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write( "默认时长为：" + maxInactiveInterval + "秒");
    }

    /**
     * 设置3s销毁Session会话
     * @Author lichuang
     * @Date 2021/8/17 19:28
     * @param req
     * @param resp
     * @return void
     */
    protected void Life3s(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setMaxInactiveInterval(3);
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write( "销毁时长为：" + maxInactiveInterval + "秒");
    }

    /**
     * 设置立即销毁
     * @Author lichuang
     * @Date 2021/8/17 19:44
     * @param req
     * @param resp
     * @return void
     */
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 马上超时
        req.getSession().invalidate();
        resp.getWriter().write( "销毁时长为0秒");
    }

}
