package 注解练习;

import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

/**
 *
 * （1）.编写一个Person类，使用Override注解它的toString方法
 * （2）.自定义一个名为“MyTiger”的注解类型，它只可以使用在方法上，
 * 带一个String类型的value属性，然后在第1题中的Person类上正确使用。
 *
 *
 * @author lichuang
 * @create 2021-07-11 21:10
 */
public class Person {

    @MyTiger
    @Override
    public String toString(){

        return "Person";
    }

}

@Target(METHOD)
@interface MyTiger{

    String value()default "Person";

}
