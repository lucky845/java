package 练习;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题
 *
 *
 * @author lichuang
 * @create 2021-07-07 20:14
 */
public class ListExer {

    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);// [1,2]
//        System.out.println(list);// [1,3]
    }
    private static void updateList(List list) {
        list.remove(2);
//        list.remove(new Integer(2));
    }

}
