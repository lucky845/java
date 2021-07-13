package 练习三;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *一个文本文件中存储着武汉所有高校在校生的姓名,格式如下:
 * 每行一个名字,姓与名以空格隔开:
 * 张 三
 * 李 四
 * 王 小五
 * 现在想统计所有的姓氏在文件出现的次数.
 *
 *
 *
 * @author lichuang
 * @create 2021-07-10 15:33
 */
public class Test3 {
    public static void main(String[] args) {
        FileInputStream fis = null;

        try {
            Properties pros = new Properties();
            fis =  new FileInputStream("D:\\应用软件\\Java\\day07\\Student.txt");
            pros.load(fis);
            Object surname = pros.get("surname");
            Object name = pros.get("name");
            System.out.println(surname + " " + name);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
