package com.jdbc4.connection;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author lichuang
 * @description 测试DBCP连接池技术
 * @create 2021-08-09 17:54
 */
//方式一：不推荐
public class DBCPTest {

    /**
     * @Author lichuang
     * @Description //TODO 测试DBCP连接池技术
     * @Date 2021/8/9 18:04
     * @param
     * @return void
     */
    @Test
    public void testGetConnection() throws Exception{
        //创建了DBCP的数据库连接池
        BasicDataSource source = new BasicDataSource();

        //设置基本信息
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql:///test");
        source.setUsername("root");
        source.setPassword("root");

        //还可以设置其他涉及数据库连接池的管理属性
        source.setInitialSize(10);
        source.setMaxActive(10);

        Connection conn = source.getConnection();
        System.out.println(conn);

    }

    //方式二：推荐：使用配置文件
    @Test
    public void testGetConnection1() throws Exception{

        Properties pros = new Properties();
        //方式一：
//        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
        //方式二：
        FileInputStream is = new FileInputStream(new File("src/dbcp.properties"));

        pros.load(is);

        //创建一个数据库连接池
        DataSource source = BasicDataSourceFactory.createDataSource(pros);

        Connection conn = source.getConnection();
        System.out.println(conn);

    }


}
