package com.book.web;

import com.book.pojo.Book;
import com.book.pojo.Page;
import com.book.server.BookService;
import com.book.server.impl.BookServiceImpl;
import com.book.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lichuang
 * @create 2021-08-17 11:42
 */
public class ClientBookServlet extends BaseServlet{

    private BookService bookService = new BookServiceImpl();

    /**
     * 处理分页功能
     * @Author lichuang
     * @Date 2021/8/16 22:08
     * @param req
     * @param resp
     * @return void
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2 调用BookService.page(pageNo，pageSize)：Page对象
        Page<Book> page = bookService.page(pageNo,pageSize);

        page.setUrl("client/BookServlet?action=page");

        //3 保存Page对象到Request域中
        req.setAttribute("page",page);
        //4 请求转发到页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }

    /**
     * 首页按价格查询功能
     * @Author lichuang
     * @Date 2021/8/17 12:54
     * @param req
     * @param resp
     * @return void
     */
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数 pageNo 和 pageSize 和 min 以及 max
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);

        //2 调用BookService.page(pageNo，pageSize)：Page对象
        Page<Book> page = bookService.pageByprice(pageNo,pageSize,min,max);

        StringBuilder stringBuilder = new StringBuilder("client/BookServlet?action=pageByPrice");
        // 如果有最小价格的参数，追加到分页条的地址栏中
        if(req.getParameter("min") != null){
            stringBuilder.append("&min=").append(req.getParameter("min"));
        }
        // 如果有最大价格的参数，追加到分页条的地址栏中
        if(req.getParameter("max") != null){
            stringBuilder.append("&max=").append(req.getParameter("max"));
        }

        page.setUrl(stringBuilder.toString());

        //3 保存Page对象到Request域中
        req.setAttribute("page",page);
        //4 请求转发到页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }


}
