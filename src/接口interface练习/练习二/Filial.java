package 接口interface练习.练习二;

public interface Filial {// 孝顺的
    default void help() {
        System.out.println("老妈，我来救你了");
    }
}

