package 练习二;

import org.junit.Test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中（下一章：
 * TreeSet 需使用泛型来定义）
 * 分别按以下两种方式对集合中的元素进行排序，并遍历输出：
 * 1). 使 Employee 实现 Comparable 接口，并按 name 排序
 * 2). 创建 TreeSet 时传入 Comparator 对象，按生日日期的先后排序。
 *
 *
 *
 * @author lichuang
 * @create 2021-07-08 16:59
 */
public class EmployeeTest {

    MyDate date1 = new MyDate(2000,11,10);
    MyDate date2 = new MyDate(2001,06,03);
    MyDate date3 = new MyDate(2000,03,18);
    MyDate date4 = new MyDate(2001,07,17);
    MyDate date5 = new MyDate(2004,05,06);

    // 1)使用自然排序
    @Test
    public void test1(){
        TreeSet set = new TreeSet();

        set.add(new Employee("zhoujielun",12,date1));
        set.add(new Employee("linjunjie",13,date2));
        set.add(new Employee("zhangjie",14,date3));
        set.add(new Employee("xuliang",15,date4));
        set.add(new Employee("wangshulong",16,date5));

        for(Object obj: set){
            System.out.println(obj);
        }
    }

    // 2) 定制排序
    @Test
    public void test2(){
        Set set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Employee && o2 instanceof Employee){
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;

                    MyDate b1 = e1.getBirthday();
                    MyDate b2 = e2.getBirthday();

                    // 方法一:
//                    // 比较年
//                    int minusYear = b1.getYear() - b2.getYear();
//                    if(minusYear != 0){
//                        return minusYear;
//                    }
//                    // 比较月
//                    int minusMonth = b1.getMonth() - b2.getMonth();
//                    if(minusMonth != 0){
//                        return minusMonth;
//                    }
//                    // 比较日
//                    return b1.getDay() - b2.getDay();

                    // 方法二:
                    return b1.compareTo(b2);

                }
                    throw new RuntimeException("输入的数据类型不匹配");

            }
        });

        set.add(new Employee("zhoujielun",12,date1));
        set.add(new Employee("linjunjie",13,date2));
        set.add(new Employee("zhangjie",14,date3));
        set.add(new Employee("xuliang",15,date4));
        set.add(new Employee("wangshulong",16,date5));

        for(Object obj: set){
            System.out.println(obj);
        }
    }

}
