package 练习三;

import java.util.*;

/**
 *
 * 请从键盘随机输入10个整数保存到List中，并按倒序、从大
 * 到小的顺序显示出来
 *
 * @author lichuang
 * @create 2021-07-10 15:32
 */
public class Test1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List list = new ArrayList();

        for (int i = 0; i < 10; i++) {
            list.add(sc.nextInt());
        }

        System.out.println("按照倒序的顺序显式：");
        Collections.reverse(list);// 倒序
        // 遍历
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("按照从大到小的顺序显式：");
        Collections.sort(list);// 默认从小到大

        Collections.reverse(list);// 倒序
        // 遍历
        iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
