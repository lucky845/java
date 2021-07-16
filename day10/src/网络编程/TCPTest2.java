package 网络编程;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP网络编程
 * 例子2：客户端发送文件给服务端，服务端将文件保存在本地。
 *
 *
 * @author lichuang
 * @create 2021-07-16 21:52
 */
public class TCPTest2 {

    /*
    这里涉及到的异常应该使用cry-catch-finally处理
     */

    // 客户端
    @Test
    public void client() throws IOException {
        // 1.创建Socket对象,指明服务器端的ip和端口号
        Socket socket = new Socket(InetAddress.getByName("192.168.1.4"),9090);
        // 2.获取一个输出流,用于输出数据
        OutputStream os = socket.getOutputStream();
        // 3.指明要输出的文件路径
        FileInputStream fis = new FileInputStream("beauty.jpg");
        // 4.写出数据的操作
        byte[] buffer = new byte[1024];
        int len;
        while((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }
        // 5.关闭资源
        fis.close();
        os.close();
        socket.close();



    }

    // 服务器端
    @Test
    public void server() throws IOException {
        // 1.创建服务器端的ServerSocket,指明自己的端口号
        ServerSocket ss = new ServerSocket(9090);
        // 2.调用accept()表示接收到来自于客户端的socket
        Socket socket = ss.accept();
        // 3.获取输入流
        InputStream is = socket.getInputStream();
        // 4.指明输入的文件的路径
        FileOutputStream fos = new FileOutputStream("beauty1.jpg");
        // 5.读取输入流中的数据
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }

        // 6.关闭资源
        fos.close();
        is.close();
        socket.close();
        ss.close();


    }

}
