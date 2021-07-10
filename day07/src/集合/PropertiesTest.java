package 集合;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author lichuang
 * @create 2021-07-10 13:39
 */
public class PropertiesTest {

    //Properties:常用来处理配置文件。key和value都是String类型
    public static void main(String[] args)  {
        FileInputStream fis = null;
        try {
            Properties pros = new Properties();
            fis = new FileInputStream("D:\\应用软件\\Java\\day07\\jdbc.properties");
            pros.load(fis);
            Object name = pros.get("name");
            Object password = pros.get("password");
            System.out.println("name="+name+","+"password="+password);
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
