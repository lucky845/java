package 常用类.常用类一;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * jdk 1.8之前的日期时间的API的测试
 * 1. System类中的currentTimeMillis();
 * 2. java.util.Date和子类java.sql.Date
 * 3. SimpleDateFormat
 * 4. Calendar
 *
 *
 * @author lichuang
 * @create 2021-07-02 22:03
 */
public class DateTimeTest {
    /*
    SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析

    1.两个操作：
    1.1 格式化：日期 --> 字符串
    1.2 解析：格式化的逆过程：字符串 --> 日期

    2. simpleDateFormat的实例化


     */

    @Test
    public void teatSimpleDateFormat() throws ParseException {
        // 实例化SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat();

        // 格式化:日期 --> 字符串
        Date date = new Date();
        System.out.println(date); // Fri Jul 02 22:20:52 CST 2021

        String format = sdf.format(date);
        System.out.println(format); // 2021/7/2 下午10:20

        // 解析：格式化的逆过程：字符串 --> 日期
//        String str = "2019-08-09";
//            Date date1 = sdf.parse(str);
//            System.out.println(date1); // 异常

        String str1 = "2021/7/2 下午10:20";
            Date date1 = sdf.parse(str1);
            System.out.println(date1); // Fri Jul 02 22:20:00 CST 2021

        // **************按指定的方式格式化和解析：调用带参的构造器************
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MMMMM.dd GGG hh:mm");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // 格式化
        String format1 = sdf1.format(date);
        System.out.println(format1); // 2021-07-02 10:35:21
        // 解析:要求字符串必须符合SimpleDateFormat识别的格式(通过构造器参数体现)
        // 否则，抛异常
        Date date2 = sdf1.parse("2021-07-02 10:35:21");
        System.out.println(date2); // Fri Jul 02 10:35:21 CST 2021

    }

    /*
    练习一：字符串"2020-09-08"转换为java.sql.Date
     */

    @Test
    public void testExer1() throws ParseException {
        String birth = "2020-09-08";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(birth);
//        System.out.println(date);

        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate); // 2020-09-08

    }

    /*
    练习二："三天打渔两天晒网" 1990-01-01 xxxx-xx-xx 打鱼还是晒网?

    举例：2020-09-08 ？总天数

    总天数 % 5 == 1，2，3：打鱼
    总天数 % 5 == 4，0：晒网

    总天数的计算？
    方式一：(date2.getTime() - date1.getTime()) / (1000 * 60 *60 *24) + 1
    方式二：1990-01-01 --> 2019-12-31 + 2020-01-01 --> 2020-09-08
     */

    // 方式一
    @Test
    public void testExer2() throws ParseException {
        String date1 = "1990-01-01";
        String date2 = "2020-09-08";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date3 = sdf.parse(date1);
        Date date4 = sdf.parse(date2);

        long day = ((date4.getTime() - date3.getTime()) / (1000 * 60 * 60 *24) + 1);
        if(day % 5 == 1 || day % 5 == 2 || day % 5 == 3){
            System.out.println("打鱼");
        }
        if(day % 5 == 0 || day % 5 == 4){
            System.out.println("晒网");
        }

    }

    // 方式二
//    @Test
//    public void testExer3() throws ParseException {
//        String date1 = "1990-01-01";
//        String date2 = "2020-09-08";
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date date3 = sdf.parse(date1);
//        Date date4 = sdf.parse(date2);
//
//       long l1 = 2019 - 1990;
//       long l2 =
//
//
//    }

    /*
    Calendar日历类(抽象类)的使用
     */

    @Test
    public void testCalendar(){
        // 1. 实例化
        // 方式一：创建其子类(GregorianCalendar)的对象
        // 方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.getClass());

        // 2. 常用方法
        // get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        // set()
        // Calendar可变性
        calendar.set(Calendar.DAY_OF_MONTH,22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        // add()
        calendar.add(Calendar.DAY_OF_MONTH,-3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        // getTime()
        Date date = calendar.getTime();
        System.out.println(date);

        // setTime(): Date ---> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

    }
}
