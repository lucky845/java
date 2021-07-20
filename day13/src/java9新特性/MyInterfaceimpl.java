package java9新特性;

/**
 * @author lichuang
 * @description
 * @create 2021-07-20 16:17
 */
public class MyInterfaceimpl implements MyInterface {
    @Override
    public void methodAbstract() {

    }

    @Override
    public void methodDefault() {
        System.out.println("实现类重写了接口中的默认方法");
    }

    public static void main(String[] args) {
        // 接口中的静态方法只能由自己调用
        MyInterface.methodStatic();
        // 接口的实现类不能调用接口的静态方法
//        MyInterfaceimpl.methodStatic();

        MyInterfaceimpl impl = new MyInterfaceimpl();
        impl.methodDefault();
        // 私有方法不能在接口外调用
//        impl.methodPrivate();
    }
}
