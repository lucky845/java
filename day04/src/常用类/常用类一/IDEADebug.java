package 常用类.常用类一;

import org.junit.Test;

/**
 * @author lichuang
 * @create 2021-07-02 21:51
 */
public class IDEADebug {

    @Test
    public void testStringBuffer(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);

        System.out.println(sb.length());// 4

        System.out.println(sb);// "null"

        StringBuffer sb1 = new StringBuffer(str); // 抛异常
        System.out.println(sb1);// 未执行
    }
}
