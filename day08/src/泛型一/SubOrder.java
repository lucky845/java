package 泛型一;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @create 2021-07-13 14:48
 */
public class SubOrder extends Order<Integer>{

    public static <E> List<E> copyFromArrayToList(E[] arr){

        ArrayList<E> list = new ArrayList<>();

        for(E e: arr){
            list.add(e);
        }
        return list;

    }

}


