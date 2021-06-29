package Test;

public interface AP {

    public static final int resistPhysic = 100;

    //resistMagic即便没有显式的声明为 public static final
    //但依然默认为public static final
    int resistMagic = 0;

    public void magicAttack();
}
