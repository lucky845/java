package Object的equals方法.Object练习3;

public class Circle extends GeometricObject {
    private double radius;

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, double weight) {
        this.radius = radius;
        this.color = color;
        this.weight = weight;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double findArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof Circle) {
            Circle circle = (Circle) obj;
            return this.radius == circle.radius && this.color == circle.color;
        }
        return false;
    }

    @Override
    public String toString() {
        return "半径为:" + radius;
    }
}
