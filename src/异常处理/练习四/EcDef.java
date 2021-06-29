package 异常处理.练习四;

public class EcDef extends RuntimeException{

    static final long serialVersionUID = 1346544653435L;

    public EcDef(){ }

    public EcDef(String msg){
        super(msg);
    }

    }
