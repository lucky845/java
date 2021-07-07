package 集合;

/**
 * 1. list接口框架
 *      |----collection接口：单例集合，用来存储一个一个的对象
 *           |----list接口：存储有序的、可重复的数据 ---> “动态”数组
 *               |----arrylist：作为list的主要实现类；线程不安全的，效率高；底层使用object[] elementdate存储
 *               |----linkedlist：对于频繁的插入、删除操作，使用此类效率比arrayslist高；底层使用双向链表存储
 *               |----vector：作为list的古老实现类；线程安全的，效率低；底层使用object[] elementdate存储
 *
 * 2. arrayliat的源码分析：
 *    2.1 jdk 7情况下
 *      arraylist list = new arraylist(); // 底层创建了长度是10的object[]数组elementdate
 *      list.add(123); // elementdate[0] = new integer(123);
 *      ...
 *      list.add(11); // 此次的添加导致底层elementdate数组容量不够，则扩容。
 *      默认情况下，扩容为原来的容量的1.5倍，同时需要将原有数组中的数据复制到新的数组中。
 *
 *      结论：建议开发中使用带参的构造器：arraylist list = new arraylist(int capacity);
 *
 *    2.2 jdk 8 中arraylist的变化：
 *      arraylist list = new arraylist(); // 底层object[] elementdate初始化为{}，并没有创建长度为10的数组
 *
 *      list.add(123); // 第一次调用add()时，底层才创建了长度为10的数组，并将数据123添加到elementdate[0]
 *      ...
 *      后续的添加和扩容操作与jdk 7 无异
 *
 *    2.3 小结：jdk 7 中的arraylist的创建类似于单例的饿汉式，而jdk 8 中的arraylist的对象的创建类似于单例的懒汉式，
 *             延迟了数组的创建，节省内存。
 *
 *    3. linkedlist的源码分析：
 *      linkedlist list = new linkedlist();
 *
 *
 *
 * 面试题：arrylist、linkedlist、vector三者的异同? 同：三个类都实现了list接口，存储数据的特点相同:存储有序的、可重复的数据
 * 不同：见上
 *
 * @author lichuang
 * @create 2021-07-07 9:37
 */
public class ListTest {


}
