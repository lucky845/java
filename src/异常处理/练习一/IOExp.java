package 异常处理.练习一;
/*
import java.io.*;
public class IOExp {
    public static void main(String[] args) {
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
 */
import java.io.*;

public class IOExp {
    public static void main(String[] args) {
        FileInputStream in = null;
        try {
            in = new FileInputStream("atguigushk.txt");
            int b;
            b = in.read();
            while (b != -1) {
                System.out.print((char) b);
                b = in.read();
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally{
            try {
                if(in != null)
                in.close();
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
