package 常用类.练习;

/**
 *
 * 一道面试题
 *
 * @author lichuang
 * @create 2021-06-23 19:26
 */
public class StringTest {

    String str = new String("good");
    char[] ch = {'t','e','s','t'};

    public void change(String str,char ch[]){
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args){
        StringTest ex = new StringTest();
        ex.change(ex.str,ex.ch);
        System.out.println(ex.str); // good
        System.out.println(ex.ch); // best

    }
}
