package com.jdbc3.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class JDBCUtils {

    /**
     * @Author lichuang
     * @Description 操作数据库的工具类
     * @Date 2021/8/7 18:26
     * @param null
     * @return conn
     */
    public static Connection getConnection() throws Exception {

        // 1.读取配置文件中的4个基本信息
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        // 2.加载驱动
        Class.forName(driverClass);

        // 3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;

    }

    /**
     * @Author lichuang
     * @Description 关闭资源的方法
     * @Date 2021/8/7 18:32
     * @param conn
     * @param ps
     * @return void
     */
    public static void closeResource(Connection conn, Statement ps){

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                    throwables.printStackTrace();
            }
        }
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    /**
     * @Author lichuang
     * @Description 关闭资源的操作
     * @Date 2021/8/7 19:57
     * @param conn
     * @param ps
     * @param rs
     * @return void
     */
    public static void closeResource(Connection conn, Statement ps, ResultSet rs){

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

}
