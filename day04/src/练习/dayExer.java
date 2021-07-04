package 练习;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 * @author lichuang
 * @create 2021-07-04 19:18
 */
public class dayExer {

    /*
    1.	将字符串”2017-08-16”转换为对应的java.sql.Date类的对象。（使用JDK8之前或JDK8中的API皆可）
     */

    @Test
    public void test1() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        Date date = sdf.parse("2017-08-16");

        java.sql.Date date1 = new java.sql.Date(date.getTime());
        System.out.println(date1);

    }

    /*
    自定义Person类如下，如何实现自然排序（按姓名从小到大排序），代码说明
     */

    @Test
    public void test2(){

        Person[] p = new Person[3];
        p[0] = new Person("a",11);
        p[1] = new Person("b",12);
        p[2] = new Person("c",13);

        Arrays.sort(p);

        System.out.println(Arrays.toString(p));

    }

    /*
    提供定制排序涉及到的接口的实现类对象，并按Person类的年龄从大到小排序
     */

    @Test
    public void test3(){

        Person[] p = new Person[3];
        p[0] = new Person("a",11);
        p[1] = new Person("b",12);
        p[2] = new Person("c",13);

        Arrays.sort(p, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Person && o2 instanceof Person){
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                   if(p1.getAge() > p2.getAge()){
                       return -1;
                   }else if(p1.getAge() < p2.getAge()){
                       return 1;
                   }else{
                       return -Double.compare(p1.getAge(),p2.getAge());
                   }
                }
                throw new RuntimeException("传入的数据类型异常! ");
            }

        });

        System.out.println(Arrays.toString(p));
    }
}
