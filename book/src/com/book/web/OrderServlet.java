package com.book.web;

import com.book.pojo.Cart;
import com.book.pojo.Order;
import com.book.pojo.OrderItem;
import com.book.pojo.User;
import com.book.server.OrderService;
import com.book.server.UserService;
import com.book.server.impl.OrderServiceImpl;
import com.book.server.impl.UserServiceImpl;
import com.book.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author lichuang
 * @create 2021-08-18 17:36
 * @project_name javaWEB
 */
public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderServiceImpl();
    private UserService userService = new UserServiceImpl();

    /**
     * 生成订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 先获取Cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        // 获取Userid
        User loginUser = (User) req.getSession().getAttribute("user");

        if (loginUser == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }

//        System.out.println("OrderServlet程序在" + Thread.currentThread().getName() + "线程中");

        Integer userId = loginUser.getId();
//        调用orderService.createOrder(Cart,Userid);生成订单
        String orderId = null;
//        try {
            orderId = orderService.createOrder(cart, userId);

            // 因为需要给每一个Servlet每个方法调用Service.xxx()都需要加上try-catch(所以使用TransactionFilter管理事务)

//            JdbcUtils.commitAndClose(); // 提交事务

//        } catch (Exception e) {
//            JdbcUtils.rollbackAndClose(); // 回滚事务
//            e.printStackTrace();
//        }

//        req.setAttribute("orderId", orderId);
        // 请求转发到/pages/cart/checkout.jsp
//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);

        req.getSession().setAttribute("orderId",orderId);

        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }

    /**
     * 我的订单
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void queryOrdersById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        Integer userId = user.getId();
        List<Order> userOrders = orderService.queryOrdersById(userId);
        req.getSession().setAttribute("userOrders",userOrders);
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req, resp);
    }

    /**
     * 订单管理，查看所有订单
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void queryOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = orderService.queryOrders();
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req, resp);
    }

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showOrderItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String orderId = req.getParameter("orderId");
        int userId = WebUtils.parseInt(req.getParameter("userId"), 0);
        String createTime = req.getParameter("createTime");
        //调用service
        List<OrderItem> orderItems = orderService.showOrderItem(orderId);
        String username = orderService.queryUserById(userId);
        //计算总消费
        BigDecimal consumption = new BigDecimal(0);
        for (OrderItem orderItem : orderItems) {
            //System.out.println(orderItem.getTotalPrice());
            consumption = consumption.add(orderItem.getTotalPrice());
        }

        //保存到Session域中
        req.setAttribute("orderId",orderId);
        req.setAttribute("username",username);
        req.setAttribute("createTime",createTime);
        req.setAttribute("consumption",consumption);
        req.getSession().setAttribute("orderItems", orderItems);
        //请求转发
        req.getRequestDispatcher("/pages/order/order_detail.jsp").forward(req, resp);
    }

    /**
     * 修改订单状态
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String orderId = req.getParameter("orderId");
        int status = WebUtils.parseInt(req.getParameter("status"), 0);
        //调service
        orderService.updateOrderByOrderId(orderId,status);
        //重定向
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
