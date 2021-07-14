package IO流;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用
 *
 * 1. 缓冲流
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 * 2. 作用：提高流的读取、写入速度
 *      提高读写速度的原因：提供了一个缓冲区
 *
 * 3. 处理流，就是”嵌套“在已有的流的基础上
 *
 *
 * @author lichuang
 * @create 2021-07-14 18:32
 */
public class BufferedTest {

    /*
    实现非文本文件的复制
     */
    @Test
    public void BufferedStream(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            // 1. 造文件
            File srcFile = new File("爱情与友情.jpg");
            File destFile = new File("爱情与友情3.jpg");

            // 2.造流
            // 2.1 造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            // 2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            // 3. 复制的细节：读取、写入
            byte[] buffer = new byte[10];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);

//                bos.flush(); // 刷新缓冲区

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bos != null){

                // 4. 资源关闭
                // 要求1：先关闭外层的流，再关闭内层的流
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis != null){

                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // 说明： 关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略。
//        fos.close();
//        fis.close();
            }
        }


    }

    // 实现文件复制的方法
    public void CopyFileWithBuffered(String srcPath,String destPath){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            // 1. 造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            // 2.造流
            // 2.1 造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            // 2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            // 3. 复制的细节：读取、写入
            byte[] buffer = new byte[1024];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bos != null){

                // 4. 资源关闭
                // 要求1：先关闭外层的流，再关闭内层的流
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis != null){

                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // 说明： 关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略。
//        fos.close();
//        fis.close();
            }
        }
    }

    @Test
    public void testCopyFileWithBuffered(){

        long start = System.currentTimeMillis();

        String srcPath = "D:\\应用软件\\Java\\day09\\雷姆.jpg";
        String destPath = "D:\\应用软件\\Java\\day09\\雷姆2.jpg";


        CopyFileWithBuffered(srcPath,destPath);

        long end = System.currentTimeMillis();

        System.out.println("复制花费的时间为：" + (end - start)); // 3
    }

    /*
    使用BufferedReader和BufferWriter实现文本文件的复制
     */
    @Test
    public void testBufferedReaderBufferWriter(){
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            // 创建文件和相应的流
            br = new BufferedReader(new FileReader(new File("dbcp.txt")));
            bw = new BufferedWriter(new FileWriter(new File("dbcp1.txt")));

            // 读写操作
            // 方式一：
//            char[] cbuf = new char[1024];
//            int len;
//            while((len = br.read(cbuf)) != -1){
//                bw.write(cbuf,0,len);
//    //            bw.flush();
//            }

            // 方式二：
            String data;
            while((data = br.readLine()) != null){
                // 方法一：
//                bw.write(data + "\n");// data中不包含换行符
                // 方法二：
                bw.write(data);// data中不包含换行符
                bw.newLine(); // 提供换行的操作
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null){
            //关闭资源
                try {
                     br.close();
                } catch (IOException e) {
                     e.printStackTrace();
                }

            }

            if(bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }



}
