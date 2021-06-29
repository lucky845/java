package 异常处理.练习三;
/*
练习3：判断程序的输出结果
 */
public class ReturnExceptionDemo {
    static void methodA(){
        try{
            System.out.println("进入方法A");
            throw new RuntimeException("制造异常");
        }finally{
            System.out.println("用A方法的finally");
        }
    }

    static void methodB(){
        try{
            System.out.println("进入方法B");
            return;
        }finally{
            System.out.println("调用B方法的finally");
        }
    }

    public static void main(String[] args) {
        try{
            methodA(); // 进入方法A   用A方法的finally
        }catch(RuntimeException e){
//            System.out.println(e.getMessage()); // 制造异常
            e.printStackTrace();
        }
        methodB(); // 进入方法B   用B方法的finally

    }
}
