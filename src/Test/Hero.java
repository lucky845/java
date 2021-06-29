package Test;

public abstract class Hero {
    String name;

    float hp;

    float armor;

    int moveSpeed;

    public static void main(String[] args) {

    }

    // 抽象方法attack
    // Hero的子类会被要求实现attack方法
    public abstract void attack();

}