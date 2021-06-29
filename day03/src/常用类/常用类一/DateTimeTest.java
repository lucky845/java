package 常用类.常用类一;

import org.junit.Test;

import java.util.Date;

/**
 *
 * JDK 8之前日期和时间的API测试
 *
 * @author lichuang
 * @create 2021-06-28 21:47
 */
public class DateTimeTest {

    // 1.System类中的currentTimeMillis()
    @Test
    public void test(){

        long time = System.currentTimeMillis();
        // 返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
        // 称为时间戳
        System.out.println(time); // 1624888577638
    }

    /*
    java.util.Date类
            |----java.sql.Date类

    1. 两个构造器的使用
            构造器一：Date():创建一个对应当前时间的Date对象
            构造器二：创建指定毫秒数的Date对象
    2. 两个方法的使用
            >toString():显示当前的年、月、日、时、分、秒
            >getTime():获取当前Date对象对应的毫秒数。（时间戳）

    3. java.sql.Date对应的是数据库中的日期类型的变量
            >如何实例化
            >如何将util.Date对象转化为sql.Date对象

     */
    @Test
    public void test2(){
        // 构造器一：Date():创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString()); // Mon Jun 28 21:58:11 CST 2021

        System.out.println(date1.getTime()); // 1624888556006

        // 构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(1624888556006L);
        System.out.println(date2.toString()); // Mon Jun 28 21:55:56 CST 2021

        // 创建java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(342424242424L);
        System.out.println(date3.toString()); // 1980-11-07

        // 如何将util.Date对象转化为sql.Date对象
        // 情况一：
//        Date date4 = new java.sql.Date(233313123L);
//        java.sql.Date date5 = (java.sql.Date)date4;
        //情况二：
        Date date6 = new Date();
//        java.sql.Date date7 = (java.sql.Date)date6; // 报错
        java.sql.Date date7 = new java.sql.Date(date6.getTime());
        


    }
}
