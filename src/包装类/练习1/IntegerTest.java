package 包装类.练习1;

import org.junit.Test;

/*
关于包装类的练习题
 */
public class IntegerTest {
    @Test
    public void test1() {

        // 如下两个题目输出结果相同吗？各是什么：
        Object o1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(o1);// 1.0

        Object o2;
        if (true)
            o2 = new Integer(1);
        else
            o2 = new Double(2.0);
        System.out.println(o2);// 1
    }

    @Test
    public void test2(){
            Integer i = new Integer(1);
            Integer j = new Integer(1);
            System.out.println(i == j); // false
            Integer m = 1;
            Integer n = 1;
            System.out.println(m == n);// true
            Integer x = 128;
            Integer y = 128;
            System.out.println(x == y);// false
    }

}
