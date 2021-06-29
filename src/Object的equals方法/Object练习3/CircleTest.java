package Object的equals方法.Object练习3;

/*
定义两个类，父类GeometricObject代表几何形状，子类Circle代表圆形。
写一个测试类，创建两个Circle对象，判断其颜色是否相等；利用equals方法判断其半径是否相等；利用
toString()方法输出其半径。
 */
public class CircleTest {

    public static void main(String[] args) {
        Circle c1 = new Circle(2, "绿色", 10);
        Circle c2 = new Circle(2, "绿色", 10);

        System.out.println(c1.equals(c2));

        System.out.println(c1);
        System.out.println(c2);

    }
}
