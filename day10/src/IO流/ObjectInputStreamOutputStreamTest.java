package IO流;

import org.junit.Test;

import java.io.*;

/**
 * 对象流的使用
 * 1.ObjectInputStream和ObjectOutputStream
 * 2.作用：用于存储和读取基本数据类型数据或对象的处理流。他的强大之处就是可以把java中的对象写入
 *      到数据源中，也能把对象从数据源中还原回来。
 *
 * 3.要想一个Java类是可序列化的，需要满足相应的要求。见Person类
 *
 * 4.序列化机制：
 * 对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从
 * 而允许把这种二进制流持久地保存在磁盘上，或通过网络将这种二进制流传
 * 输到另一个网络节点。
 * 当其它程序获取了这种二进制流，就可以恢复成原来的Java对象。
 *
 *
 *
 * @author lichuang
 * @create 2021-07-15 20:24
 */
public class ObjectInputStreamOutputStreamTest {

    /*
    序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去
    使用ObjectOutputStream实现
     */
    @Test
    public void testObjectOutputStream(){
        ObjectOutputStream oos = null;
        try {
            // 1.
            oos = new ObjectOutputStream(new FileOutputStream("Object.dat"));
            // 2.
            oos.writeObject(new String("我爱北京天安门"));
            oos.flush(); // 刷新操作

            // 序列化Person对象
            oos.writeObject(new Person("小明",12));
            oos.flush();

            oos.writeObject(new Person("小王",13,1001,new Account(5000)));
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos != null){
                // 3.
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    反序列化：将磁盘文件中的对象还原为内存中的一个java对象
    使用ObjectInputStream实现
     */
    @Test
    public void testObjectInputStream() {
        ObjectInputStream ois = null;
        try {
            // 1.
            ois = new ObjectInputStream(new FileInputStream("Object.dat"));
            // 2.
            Object obj = ois.readObject();
            String str = (String) obj;
            System.out.println(str);

            // 取出Person对象
            Person p = (Person)ois.readObject();
            Person p1 = (Person)ois.readObject();

            System.out.println(p);
            System.out.println(p1);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois != null){
                // 3.
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
