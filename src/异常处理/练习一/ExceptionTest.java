package 异常处理.练习一;
/*
编写一个类ExceptionTest，在main方法中使用try、catch、finally，要求：
在try块中，编写被零除的代码。
在catch块中，捕获被零除所产生的异常，并且打印异常信息
在finally块中，打印一条语句。
 */
public class ExceptionTest {
    public static void main(String[] args) {
        try{
            int a = 10;
            int b = 0;
            System.out.println(a / b);
        }catch(RuntimeException e){
//            e.printStackTrace();
            System.out.println( e.getMessage());
        }finally {
            System.out.println("我一定会被执行！");
        }
    }
}
