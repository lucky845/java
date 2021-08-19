package com.book.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author lichuang
 * @description
 * @create 2021-08-14 15:09
 */
public class JdbcUtils {

    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> coons = new ThreadLocal<>(); // 管理提交订单事务

    static{

        try {
            Properties properties = new Properties();
            // 读取jdbc.properties属性配制文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // 从流中加载数据
            properties.load(inputStream);
            // 创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取数据库池中的连接
     * @Author lichuang
     * @Date 2021/8/14 15:11
     * @param
     * @return java.sql.Connection 如果返回null，说明获取连接失败<br/>，有值就是获取成功
     */
    public static Connection getConnection(){

        Connection conn = coons.get();

        if(conn == null){
            try {
                conn = dataSource.getConnection(); // 从数据库连接池获取连接

                coons.set(conn);// 保存到ThreadLocal中，给后面的jdbc操作使用

                conn.setAutoCommit(false); // 设置手动管理事务

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return conn;
    }

    /**
     * 提交事务，并关闭释放连接
     */
    public static void commitAndClose(){
        Connection conn = coons.get();
        if(conn != null){ // 如果不为null，说明以前用过连接，操作过数据库

            try {
                conn.commit(); // 提交事务
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    conn.close(); // 关闭连接,释放资源
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        // 一定要执行remove操作，否则就会出错(因为Tomcat服务器底层使用了线程池)
        coons.remove();
    }

    /**
     * 回滚事务,并释放连接
     */
    public static void rollbackAndClose(){
        Connection conn = coons.get();
        if(conn != null){ // 如果不为null，说明以前用过连接，操作过数据库

            try {
                conn.rollback(); // 回滚事务
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    conn.close(); // 关闭连接,释放资源
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        // 一定要执行remove操作，否则就会出错(因为Tomcat服务器底层使用了线程池)
        coons.remove();
    }

   /* *//**
     * 关闭连接，放回数据库连接池
     * @Author lichuang
     * @Date 2021/8/14 15:10
     * @param conn
     * @return void
     *//*
    public static void close(Connection conn){

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }*/

}
