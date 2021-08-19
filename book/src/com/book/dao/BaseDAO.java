package com.book.dao;

import com.book.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author lichuang
 * @description
 * @create 2021-08-14 15:35
 */
public abstract class BaseDAO {

    // 使用DbUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * 用来执行：Insert、Update、Delete语句
     * @param sql
     * @param args
     * @return int 如果返回-1说明执行失败，返回其他表示影响的行数
     * @Author lichuang
     * @Date 2021/8/14 15:42
     */
    public int update(String sql, Object... args) {

//        System.out.println("BaseDAO程序在" + Thread.currentThread().getName() + "线程中");

        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e); // 下面类似操作都抛出去给OrderServlet处理(回滚事务)
        }
//        finally {
//            JdbcUtils.close(conn);
//        }
    }

    /**
     * 查询返回一个javaBean的sql语句
     * @param type 返回的对象类型
     * @param sql  执行的sql语句
     * @param args sql对应的参数
     * @return java.lang.Object
     * @Author lichuang
     * @Date 2021/8/14 15:46
     */
    public <T> T queryForOne(Class<T> type, String sql, Object... args) {

        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
//        finally {
//            JdbcUtils.close(conn);
//        }
    }

    /**
     * 查询返回多个javaBean的sql语句
     * @param type 返回的对象类型
     * @param sql  执行的sql语句
     * @param args sql对应的参数
     * @return java.util.List<T>
     * @Author lichuang
     * @Date 2021/8/14 15:50
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
//        finally {
//            JdbcUtils.close(conn);
//        }
    }

    /**
     * 执行返回一行一列的sql语句
     * @param sql  执行的sql语句
     * @param args sql对应的参数值
     * @return java.lang.Object
     * @Author lichuang
     * @Date 2021/8/14 15:55
     */
    public Object queryForSingleValue(String sql, Object... args) {

        Connection conn = JdbcUtils.getConnection();

        try {
            return queryRunner.query(conn, sql, new ScalarHandler(), args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
//        finally {
//            JdbcUtils.close(conn);
//        }

    }

}
