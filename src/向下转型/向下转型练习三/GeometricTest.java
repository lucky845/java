package 向下转型.向下转型练习三;

/*
定义三个类，父类GeometricObject代表几何形状，子类Circle代表圆形，MyRectangle代表矩形。
定义一个测试类GeometricTest，编写equalsArea方法测试两个对象的面积是否相等（注意方法的参
数类型，利用动态绑定技术），编写displayGeometricObject方法显示对象的面积（注意方法的参
数类型，利用动态绑定技术）。
 */
public class GeometricTest {
    public static void main(String[] args) {
        GeometricTest ge = new GeometricTest();

        Circle c1 = new Circle("绿色", 1.0, 4);
        Circle c2 = new Circle("绿色", 1.0, 5);

        ge.displayGeometricObjet(c1);
        boolean isEquals = ge.equalsArea(c1, c2);
        System.out.println("面积是否相等:" + isEquals);

        MyRectangle m = new MyRectangle("红色", 2.0, 4, 3);
        ge.displayGeometricObjet(m);
    }

    public void displayGeometricObjet(GeometricObject o) { // GeometricObject o = new Circle(````````):
        System.out.println("面积为:" + o.findArea()); // 虚拟方法调用
    }

    // 测试面积是否相等
    public boolean equalsArea(GeometricObject o1, GeometricObject o2) {
        return o1.findArea() == o2.findArea();


    }
}
