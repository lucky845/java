package com.book.test;

import com.book.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author lichuang
 * @description
 * @create 2021-08-14 15:28
 */
public class JdbcUtilsTest {

    @Test
    public void testJdbcUtils(){
        for (int i = 0; i < 100; i++) {

            Connection conn = JdbcUtils.getConnection();
            System.out.println(conn);
            JdbcUtils.commitAndClose();
        }


    }
}
