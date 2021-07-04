package 常用类.常用类一;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * jdk 8中日期时间API的测试
 *
 *
 * @author lichuang
 * @create 2021-07-03 17:38
 */
public class JDK8DateTimeTest {

    @Test
    public void testDate(){
        // 偏移量
        Date date1 =new Date(2020 - 1900,9 - 1,8);
        System.out.println(date1); // Tue Sep 08 00:00:00 CST 2020
    }

    /*
     LocalDate、LocalTime、LocalDateTime 的使用
     说明：
     1.localDateTime相较于LocalDate、LocalTime，使用频率更高
     2. 类似于Calendar类
     */

    @Test
    public void test1(){
        // now():获取当前日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of():设置的年、月、日、时、分、秒。没有偏移量
        LocalDateTime localDateTime1 = localDateTime.of(2020, 10, 6, 13, 23, 43);
        System.out.println(localDateTime1);

        //getXxx():获取相关的属性
        System.out.println(localDateTime.getDayOfMonth()); // 3
        System.out.println(localDateTime.getDayOfWeek()); // SATURDAY
        System.out.println(localDateTime.getDayOfYear()); // 184
        System.out.println(localDateTime.getHour()); // 18

        // 体现不可变性
        // withXxx():设置相关的属性
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(22);
        System.out.println(localDateTime); // 2021-07-03T18:31:12.212499300
        System.out.println(localDateTime2); // 2021-07-22T18:31:12.212499300

        LocalDateTime localDateTime3 = localDateTime.withHour(4);
        System.out.println(localDateTime); // 2021-07-03T18:33:37.869978800
        System.out.println(localDateTime3); // 2021-07-03T04:33:37.869978800

        // 体现不可变性
        // plusXxx(): 加  minusXxx(): 减
        LocalDateTime localDateTime4 = localDateTime.plusMonths(3); // 加3个月
        System.out.println(localDateTime);
        System.out.println(localDateTime4);

        LocalDateTime localDateTime5 = localDateTime.minusDays(6); // 减6天
        System.out.println(localDateTime);
        System.out.println(localDateTime5);
    }

    /*
    Instant的使用
    类似于java.util.Date类

     */
    @Test
    public void test2(){

        //now():获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant); // 2021-07-03T10:47:48.794858Z

        // 添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime); // 2021-07-03T18:49:32.190205700+08:00

        // toEpochMilli()获取示自1970年1月1日0时0分0秒（UTC）开始的毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        // ofEpochMilli():通过给定的毫秒数,获取Instant实例 --> Date(long millis)
        Instant instant1 = Instant.ofEpochMilli(1625310517501L);
        System.out.println(instant1);
    }

    /*
    DateTimeFormatter: 格式化与解析日期、时间
    类似于SimpleSateFormat
     */
    @Test
    public void test3(){
//        方式一:预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        // 格式化:日期 --> 字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);

        // 解析:字符串 --> 日期
        TemporalAccessor parse = formatter.parse("2021-07-04T12:26:30.6986894");
        System.out.println(parse);

//        方式二:
//        本地化相关的格式.如:ofLocalizedDateTime()
//        FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDateTime
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        // 格式化:日期 --> 字符串
        String str2 = localDateTime.format(formatter1);
        System.out.println(str2); // 2021/7/4 下午12:35

//        本地化相关的格式.如:ofLocalizedDate()
//        FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDateTime
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        // 格式化:日期 --> 字符串
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3); // 2021年7月4日星期日


//        重点:方式三:自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        // 格式化:日期 --> 字符串
        String str4 = formatter3.format(localDateTime.now());
        System.out.println(str4); // 2021-07-04 12:42:10

        // 解析:字符串 --> 日期
        TemporalAccessor parse1 = formatter3.parse("2021-07-04 12:42:10");
        System.out.println(parse1); // {NanoOfSecond=0, MicroOfSecond=0, MinuteOfHour=42, MilliOfSecond=0, HourOfAmPm=0, SecondOfMinute=10},ISO resolved to 2021-07-04

    }


}
