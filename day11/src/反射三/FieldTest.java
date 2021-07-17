package 反射三;

import org.junit.Test;
import 反射二.Person;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取运行时类的属性结构
 *
 * @author lichuang
 * @create 2021-07-17 20:25
 */
public class FieldTest {

    @Test
    public void test1(){

        Class<Person> class1 = Person.class;

        // 获取属性结构
        // getFields():获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] field = class1.getFields();
        for(Field f: field){
            System.out.println(f);
        }

        // getDeclaredFields():获取当前运行时类当中声明的所有属性(不包含父类中声明的属性)
        Field[] declaredFields = class1.getDeclaredFields();
        for (Field f: declaredFields) {
            System.out.println(f);
        }

    }

    // 权限修饰符  数据类型  变量名
    @Test
    public void test2(){

        Class<Person> class1 = Person.class;

        Field[] declaredFields = class1.getDeclaredFields();
        for (Field f: declaredFields) {
            // 1. 权限修饰符
            int modifiers = f.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");

            // 2. 数据类型
            Class<?> type = f.getType();
            System.out.print(type.getName() + "\t");

            // 3. 变量名
            String fname = f.getName();
            System.out.print(fname);

            System.out.println();


        }
    }

}
