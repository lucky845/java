package com.book.web;

import com.book.pojo.Book;
import com.book.pojo.Cart;
import com.book.pojo.CartItem;
import com.book.server.BookService;
import com.book.server.impl.BookServiceImpl;
import com.book.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @create 2021-08-18 13:16
 */
public class CartServlet extends BaseServlet{

    private BookService bookService = new BookServiceImpl();

    /**
     * 添加商品的方法(加入购物车)
     * @Author lichuang
     * @Date 2021/8/18 13:16
     * @param req
     * @param resp
     * @return void
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("加入购物车");
//        System.out.println("商品编号" + req.getParameter("id"));

        // 获取请求的参数 商品编号
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        // 调用bookService.queryBookById(id):Book得到图书的信息
        Book book = bookService.queryBookById(id);
        // 把图书信息，转换为CartItem商品项
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        // 调用Cart.addItem(CartItem);添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);

//        System.out.println(cart);
//        System.out.println("请求头Referer的值" + req.getHeader("Referer"));// 获取跳转前的URL

        req.getSession().setAttribute("lastName",cartItem.getName());

        // 重定向回原来商品所在地址页面
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 通过ajax添加购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("加入购物车");
//        System.out.println("商品编号" + req.getParameter("id"));

        // 获取请求的参数 商品编号
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        // 调用bookService.queryBookById(id):Book得到图书的信息
        Book book = bookService.queryBookById(id);
        // 把图书信息，转换为CartItem商品项
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        // 调用Cart.addItem(CartItem);添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);

//        System.out.println(cart);
//        System.out.println("请求头Referer的值" + req.getHeader("Referer"));// 获取跳转前的URL

        req.getSession().setAttribute("lastName",cartItem.getName());

        // 返回购物车总商品数量和最后一个添加的商品名称
        Map<String,Object> resultMap = new HashMap<>();

        resultMap.put("totalCount",cart.getTotalCount());
        resultMap.put("lastName",cartItem.getName());

        Gson gson = new Gson();
        String resultMapJson = gson.toJson(resultMap);

        resp.getWriter().write(resultMapJson);

    }

    /**
     * 删除商品项
     * @Author lichuang
     * @Date 2021/8/18 14:25
     * @param req
     * @param resp
     * @return void
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取商品编号
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        // 获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if(cart != null){
            // 删除了购物车商品项
            cart.deleteItem(id);
        }
        // 重定向回原来商品展示页面
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 清空购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart != null){
            // 清空购物车
            cart.clear();
        }
        // 重定向回原来商品展示页面
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 修改购物车中商品的数量
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        int count = WebUtils.parseInt(req.getParameter("count"),0);
        // 获取cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if(cart != null){
            // 修改商品数量
            cart.updateCount(id,count);
        }
        // 重定向回原来商品展示页面
        resp.sendRedirect(req.getHeader("Referer"));
    }
}




