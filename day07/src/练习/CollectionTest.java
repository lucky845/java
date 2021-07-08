package 练习;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author lichuang
 * @create 2021-07-08 14:01
 */
public class CollectionTest {

    @Test
    public void test1(){

        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(343);
        coll.add(123);

        coll.forEach(System.out::println);

    }

}
