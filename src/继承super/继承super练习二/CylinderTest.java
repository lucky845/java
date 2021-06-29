package 继承super.继承super练习二;

public class CylinderTest {
    public static void main(String[] args) {
        Circle cir = new Circle();

        Cylinder cy = new Cylinder();

        System.out.println("表面积为:" + cy.findArea() + " 体积为:" + cy.findVolume() + " 面积为:" + cir.findArea());
    }
}
