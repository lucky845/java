package 反射二;

import java.io.Serializable;

/**
 * @author lichuang
 * @create 2021-07-17 20:09
 */
public class Creature<T> implements Serializable {

    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }



}
