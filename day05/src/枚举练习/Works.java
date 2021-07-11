package 枚举练习;

/**
 *
 * 有一个接口类Works，有个反射颜色的接口ReflectColor，
 * 用上题的Color枚举类实现这个接口类，每个枚举值反射自己颜色的光。
 *
 *
 * @author lichuang
 * @create 2021-07-11 20:14
 */
public class Works implements ReflectColor{


    @Override
    public void show() {
        System.out.println("显示颜色");
    }

}

interface ReflectColor{

    void show();

}