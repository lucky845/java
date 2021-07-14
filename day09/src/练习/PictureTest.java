package 练习;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * 实现图片加密操作。
 *
 *
 *
 * @author lichuang
 * @create 2021-07-14 20:29
 */
public class PictureTest {

    // 图片的加密
    @Test
    public void test1(){

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(new File("爱情与友情.jpg"));
            fos = new FileOutputStream(new File("爱情与友情secret.jpg"));

            byte[] buffer = new byte[20];
            int len;
            while((len = fis.read(buffer)) != -1){
                // 字节数组进行修改
                // 错误的
    //            for(byte b: buffer){
    //                b = (byte) (b ^ 5);
    //            }
                // 正确的
                for(int i = 0;i < len;i++){
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }

                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){

                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fos != null){

                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    // 图片的解密
    @Test
    public void test2(){

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(new File("爱情与友情secret.jpg"));
            fos = new FileOutputStream(new File("爱情与友情4.jpg"));

            byte[] buffer = new byte[20];
            int len;
            while((len = fis.read(buffer)) != -1){
                // 字节数组进行修改
                // 错误的
                //            for(byte b: buffer){
                //                b = (byte) (b ^ 5);
                //            }
                // 正确的
                for(int i = 0;i < len;i++){
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }

                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){

                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fos != null){

                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
