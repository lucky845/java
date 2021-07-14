package IO流;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * 测试FileInputStream和FileOutputStream的使用
 *
 * 结论：
 * 1. 对于文本文件(.txt,.java,.c,.cpp)，使用字符流处理
 * 2. 对于非文本文件(.jpg,.mp3,.avi,.doc,.ppt,......)，使用字节流处理
 *
 *
 *
 * @author lichuang
 * @create 2021-07-14 16:40
 */
public class FileInputStreamFileOutputStreamTest {

    // 使用字节流FileInputStream处理文本文件可能出现乱码
    @Test
    public void testFileInputStream(){
        FileInputStream fis = null;
        try {
            // 1.File类的实例化
            File file = new File("hello.txt");

            // 2.FileInputStream流的实例化
            fis = new FileInputStream(file);

            // 3.读入的操作
            byte[] buffer = new byte[5];
            int len;
            while((len = fis.read(buffer)) != -1){
                String str = new String(buffer,0,len);
                System.out.print(str);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null)
            // 4.资源的关闭
            {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    /*
    实现对图片的复制
     */
    @Test
    public void testFileInputStreamFileOutputStream(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //
            File srcFile = new File("爱情与友情.jpg");
            File destFile = new File("爱情与友情2.jpg");

            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            // 复制的过程
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //
            try {
                if(fis != null)
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fos != null)
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    // 指定路径下文件的复制操作
    public void CopyFile(String srcPath,String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            // 复制的过程
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //
            try {
                if(fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCopyFile(){

        long start = System.currentTimeMillis();

        String srcPath = "D:\\应用软件\\Java\\day09\\雷姆.jpg";
        String destPath = "D:\\应用软件\\Java\\day09\\雷姆1.jpg";

//        String srcPath = "hello.txt";
//        String destPath = "hello3.txt";

        CopyFile(srcPath,destPath);

        long end = System.currentTimeMillis();

        System.out.println("复制花费的时间为：" + (end - start)); // 6

    }


}
