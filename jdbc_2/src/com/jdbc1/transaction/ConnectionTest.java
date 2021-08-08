package com.jdbc1.transaction;

import com.jdbc1.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;


/**
 * @author lichuang
 * @description
 * @create 2021-08-08 19:46
 */
public class ConnectionTest {

    @Test
    public void testGetConnection() throws Exception{

        Connection conn = JDBCUtils.getConnection();
        System.out.println(conn);


    }


}
