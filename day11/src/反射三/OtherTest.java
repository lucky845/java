package 反射三;

import org.junit.Test;
import 反射二.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author lichuang
 * @create 2021-07-17 21:26
 */
public class OtherTest {

    /*
    获取构造器结构

     */
    @Test
    public void test1(){

        Class<Person> class1 = Person.class;

        //getConstructors():获取当前运行时类中声明为public的构造器
        Constructor<?>[] constructors = class1.getConstructors();
        for(Constructor c : constructors){
            System.out.println(c);
        }

        System.out.println();

        //getDeclaredConstructors():获取当前运行时类中声明的所有的构造器
        Class<?>[] declaredClasses = class1.getDeclaredClasses();
        for(Class c:declaredClasses){
            System.out.println(c);
        }

    }

    /*
    获取运行时类的父类

     */
    @Test
    public void tesy2(){

        Class<Person> class1 = Person.class;

        Class<? super Person> superclass = class1.getSuperclass();
        System.out.println(superclass);

    }

    /*
    获取运行时类的带泛型的父类

     */
    @Test
    public void tesy3(){

        Class<Person> class1 = Person.class;

        Type genericSuperclass = class1.getGenericSuperclass();
        System.out.println(genericSuperclass);

    }

    /*
    获取运行时类的带泛型的父类的泛型

    代码：逻辑性代码  vs 功能性代码
     */
    @Test
    public void tesy4(){

        Class clazz = Person.class;

        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
//        System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(((Class)actualTypeArguments[0]).getName());

    }

    /*
    获取运行时类实现的接口
     */
    @Test
    public void test5(){
        Class clazz = Person.class;

        Class[] interfaces = clazz.getInterfaces();
        for(Class c : interfaces){
            System.out.println(c);
        }

        System.out.println();
        //获取运行时类的父类实现的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for(Class c : interfaces1){
            System.out.println(c);
        }

    }
    /*
        获取运行时类所在的包

     */
    @Test
    public void test6(){
        Class clazz = Person.class;

        Package pack = clazz.getPackage();
        System.out.println(pack);
    }

    /*
        获取运行时类声明的注解

     */
    @Test
    public void test7(){
        Class clazz = Person.class;

        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation annos : annotations){
            System.out.println(annos);
        }
    }

}
