package 继承super.继承super练习二;

public class Cylinder extends Circle {
    private double length;

    public Cylinder() {
        this.length = length = 1;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double findVolume() {
        return super.findArea() * length;
    }

    @Override
    public double findArea() {
        return 2 * super.findArea() + 2 * getRadius() * length;
    }
}
