package 练习二;

/**
 *
 * MyDate 类包含:
 * private 成员变量 year,month,day；并为每一个属性定义 getter, setter
 * 方法；
 *
 *
 * @author lichuang
 * @create 2021-07-08 16:50
 */
public class MyDate implements Comparable{

    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof MyDate){
            MyDate m = (MyDate) o;

            // 比较年
            int minusYear = this.getYear() - m.getYear();
            if(minusYear != 0){
                return minusYear;
            }
            // 比较月
            int minusMonth = this.getMonth() - m.getMonth();
            if(minusMonth != 0){
                return minusMonth;
            }
            // 比较日
            return this.getDay() - m.getDay();
        }else {
            throw new RuntimeException("输入的数据类型不匹配");
        }
    }
}
