package 注解练习;

import java.util.Scanner;

/**
 *
 * 声明Week枚举类，其中包含星期一至星期日的定义；
 * 在TestWeek类中声明方法中printWeek(Week week)，根据参数值打印相应的中文星期字符串。
 * 提示，使用switch语句实现。
 * 在main方法中从命令行接收一个1-7的整数(使用Integer.parseInt方法转换)，
 * 分别代表星期一至星期日，打印该值对应的枚举值，然后以此枚举值调用printWeek方法，输出中文星期。
 *
 *
 * @author lichuang
 * @create 2021-07-11 20:15
 */
public enum WeekTest {

    MONDAY("1","星期一"),
    TUESDAY("2","星期二"),
    WEDNESDAY("3","星期三"),
    THURSDAY("4","星期四"),
    FRIDAY("5","星期五"),
    SATURDAY("6","星期六"),
    SUNDAY("7","星期天");

    private String name;
    private String week;

    WeekTest(String name,String week) {
        this.week = week;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "WeekTest{" +
                "week='" + week + '\'' +
                '}';
    }
}

class TestWeek{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        switch (sc.nextInt()){
            case 1:
                System.out.println(WeekTest.MONDAY);
                printWeek(WeekTest.MONDAY);
                break;
            case 2:
                System.out.println(WeekTest.TUESDAY);
                printWeek(WeekTest.TUESDAY);
                break;
            case 3:
                System.out.println(WeekTest.WEDNESDAY);
                printWeek(WeekTest.WEDNESDAY);
                break;
            case 4:
                System.out.println(WeekTest.THURSDAY);
                printWeek(WeekTest.THURSDAY);
                break;
            case 5:
                System.out.println(WeekTest.FRIDAY);
                printWeek(WeekTest.FRIDAY);
                break;
            case 6:
                System.out.println(WeekTest.SATURDAY);
                printWeek(WeekTest.SATURDAY);
                break;
            case 7:
                System.out.println(WeekTest.SUNDAY);
                printWeek(WeekTest.SUNDAY);
                break;
        }
    }

    public static void printWeek(WeekTest week){
        switch (week){
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
            case SATURDAY:
            case SUNDAY:
                System.out.println(week.getWeek());
            default:
                System.out.println("输入错误,请重新输入!");
        }
    }
}