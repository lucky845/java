package Object的equals方法.Object练习2;

/*
请根据以下代码自行定义能满足需要的MyDate类,在MyDate类中覆盖重写equals方法,
使其判断两个MyDate类型对象的年月日都相同时,结果为true,否则为false.
 */
public class MyDateTest {
    public static void main(String[] args) {
        MyDate m1 = new MyDate(2010, 06, 01);
        MyDate m2 = new MyDate(2010, 06, 01);

        System.out.println(m1.equals(m2)); // true

        MyDate m3 = new MyDate(2010, 06, 02);

        System.out.println(m1.equals(m3)); // false
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public MyDate() {

    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof MyDate) {
            MyDate myDate = (MyDate) obj;

            return this.year == myDate.year && this.month == myDate.month
                    && this.day == myDate.day;
        }
        return false;
    }
}