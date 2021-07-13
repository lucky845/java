package 练习三;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 *
 *  利用File构造器，new 一个文件目录file
 * 1)在其中创建多个文件和目录
 * 2)编写方法，实现删除file中指定文件的操作
 *
 *
 *
 * @author lichuang
 * @create 2021-07-13 20:20
 */
public class FileDome {

    @Test
    public void test1() throws IOException {
        File file = new File("D:\\应用软件\\Java\\day08\\hello.txt");
        // 创建一个与file同目录下的另外一个文件，文件名为：haha.txt
        File destFile = new File(file.getParent(),"haha.tat");
        boolean newFile = destFile.createNewFile();
        if(newFile){
            System.out.println("创建成功！");
        }



    }
}
