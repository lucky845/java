package 接口interface练习.练习一;
/*
定义一个测试类InterfaceTest，创建两个ComparableCircle对象，调用compareTo
方法比较两个类的半径大小。
 */
public class InterfaceTest {
    public static void main(String[] args) {
        ComparableCircle c1 = new ComparableCircle(3.4);
        ComparableCircle c2 = new ComparableCircle(3.6);

        int compareValue = c1.compareTo(c2);

        if(compareValue > 0){
            System.out.println("c1对象大");
        }else if(compareValue < 0){
            System.out.println("c2对象大");
        }else{
            System.out.println("c1与c2一样大");
        }

    }
}
