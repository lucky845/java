package 泛型;

import org.junit.Test;

import java.util.*;

/**
 *
 * 泛型的使用
 * 1.jdk 5.0新增的特型
 * 2.在集合中使用泛型;
 *  总结:
 *  ① 集合接口或集合类在jdk 5.0时都修改为带泛型的结构
 *  ② 在实例化集合类时,可以指明具体的泛型类型
 *  ③ 指明完以后,在集合类或接口时,内部结构(比如:方法、构造器、属性等)使用到的类的泛型的位置,都指定为实例化的泛型类型
 *      比如:add(E e) ----> 实例化以后: add(Integer e)
 *  ④ 注意点:泛型类型必须是类,不能是基本数据类型.需要用到基本数据类型的位置,拿包装类来替换
 *  ⑤ 如果实例化时,没有指明泛型的类型.默认类型为java.long.Object类型
 *
 *
 *
 * @author lichuang
 * @create 2021-07-13 12:53
 */
public class GenericTest {

    @Test
    public void test(){
        ArrayList list = new ArrayList();

        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
        // 问题一: 类型不安全
//        list.add("Tom");

        for (Object score:list) {
            // 问题二: 强转时,可能出现ClassCastException
            int stuScore = (Integer) score;

            System.out.println(stuScore);
        }

    }

    // 在集合中使用泛型的情况:以ArrayList举例
    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
        // 编译时,就会进行类型检查,保证数据的安全
//        list.add("Tom");

        // 方式一:
//        for(Integer score : list){
//            // 避免了强转操作
//            int stuScore = score;
//
//            System.out.println(stuScore);
//        }

        // 方式二
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            int stuScore = iterator.next();
            System.out.println(stuScore);
        }
    }

    // 在集合中使用泛型的情况:以HashMap举例
    @Test
    public void test3(){
//        Map<String,Integer> map= new HashMap<String,Integer>();
        // jdk 7新特性:类型推断
        Map<String,Integer> map = new HashMap<>();

        map.put("Tom",87);
        map.put("Jerry",87);
        map.put("Jack",67);

//        map.put(123,"ABC");
        // 泛型的嵌套
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();

        while(iterator.hasNext()){
            Map.Entry<String, Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "------" + value);
        }
    }


}
