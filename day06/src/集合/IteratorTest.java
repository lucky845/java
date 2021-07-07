package 集合;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素的遍历操作,使用迭代器Iterator接口
 * 1.内部的方法:
 * next():①指针下移 ②将下移以后的集合位置上的元素返回
 * hasNext():判断是否有下一个元素
 *
 * 2.集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前。
 *
 * 3.内部定义了一个remove(),可以在遍历的时候,删除集合中的元素,此方法不同于集合直接调用remove()
 *
 * @author lichuang
 * @create 2021-07-06 21:06
 */
public class IteratorTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();
        // 方式一:
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        // 报异常:NoSuchElementException
//        System.out.println(iterator.next());

        // 方式二:不推荐
//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//        }

        // 方式三:推荐
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);

        // 错误方式一:
//        Iterator iterator = coll.iterator();
//        while (iterator.next() != null){
//            System.out.println(iterator.next());
//        }

        // 错误方式二:
        // 集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前。
        while(coll.iterator().hasNext()){
            System.out.println(coll.iterator().next());
        }

    }

    // 测试Iterator中的remove()方法
    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();

        // 删除集合中的"Tom"
        while(iterator.hasNext()){
            Object obj = iterator.next();
            if("Tom".equals(obj)){
                iterator.remove();
            }
        }

        // 遍历集合
        iterator  = coll.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
