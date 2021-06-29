package 异常处理.练习二;

import java.io.FileInputStream;
import java.io.IOException;

public class ThrowsTest {
    public static void main(String[] args) {
        ThrowsTest t = new ThrowsTest();
        try {
            t.readFile();
        } catch (IOException e) {
           e.printStackTrace();
        }
    }

    public void readFile() throws IOException{ // 在方法头部声明抛出，交给调用者处理
        FileInputStream in = new FileInputStream("atguigushk.txt");
        int b;
        b = in.read();
        while (b != -1) {
            System.out.print((char) b);
            b = in.read();
        }
        in.close();
    }

}

