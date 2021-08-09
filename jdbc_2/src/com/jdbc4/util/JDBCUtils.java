package com.jdbc4.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {


    /**
     * @Author lichuang
     * @Description //TODO 使用C3P0连接数据库
     * @Date 2021/8/9 18:21
     * @param
     * @return java.sql.Connection
     */
    //数据连接池只需要一个即可
    private static ComboPooledDataSource cpds = new ComboPooledDataSource("hellc3p0");

    public static Connection getConnection1() throws SQLException {

        Connection conn = cpds.getConnection();
        return conn;

    }


    /**
     * @Author lichuang
     * @Description //TODO 使用DBCP连接数据库
     * @Date 2021/8/9 18:19
     * @param
     * @return java.sql.Connection
     */
    private static DataSource source;

    static {

        try {
            Properties pros = new Properties();
            FileInputStream is = new FileInputStream(new File("src/dbcp.properties"));
            pros.load(is);
            source = BasicDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection2() throws SQLException {

        Connection conn = source.getConnection();

        return conn;

    }

    /**
     * @Author lichuang
     * @Description //TODO
     * @Date 2021/8/9 18:45
     * @param
     * @return java.sql.Connection
     */
    private static DataSource source1;

    static {

        try {
            Properties pros = new Properties();

            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
            pros.load(is);

            source1 = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection3() throws SQLException {

        Connection conn = source1.getConnection();

        return conn;


    }

    /**
     * @Author lichuang
     * @Description //TODO 使用dbutils.jar中提供的Dbutils工具类，实现资源的关闭
     * @Date 2021/8/9 19:56
     * @param conn
     * @param ps
     * @param rs
     * @return void
     */
    public static void closeResource(Connection conn, Statement ps, ResultSet rs){
//        try {
//            DbUtils.close(conn);
//            DbUtils.close(ps);
//            DbUtils.close(rs);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

        DbUtils.closeQuietly(conn);
        DbUtils.closeQuietly(ps);
        DbUtils.closeQuietly(rs);


    }

    /**
     * @Author lichuang
     * @Description 关闭资源的方法
     * @Date 2021/8/7 18:32
     * @param conn
     * @param ps
     * @return void
     */
    public static void closeResource1(Connection conn, Statement ps){

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
    public static void closeResource1(Connection conn, Statement ps, ResultSet rs){

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

