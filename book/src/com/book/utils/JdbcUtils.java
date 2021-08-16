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

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    /**
     * 关闭连接，放回数据库连接池
     * @Author lichuang
     * @Date 2021/8/14 15:10
     * @param conn
     * @return void
     */
    public static void close(Connection conn){

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
