package banking8.domain;

/**
 * @ClassName: OverdraftException
 * @Description:
 * @Date: 2021/10/12 23:12
 * @Author lichuang
 * @Since JDK 1.8
 */
public class OverdraftException extends Exception{

    private double deficit;

    public OverdraftException(String message,double deficit){
        this.deficit = deficit;
    }

    public double getDeficit() {
        return deficit;
    }
}
