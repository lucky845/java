package 接口interface练习.练习一;
/*
定义一个ComparableCircle类，继承Circle类并且实现CompareObject接口。在
ComparableCircle类中给出接口中方法compareTo的实现体，用来比较两个圆的半
径大小。
 */
public class ComparableCircle extends Circle implements CompareObject {

    public ComparableCircle(double redius){
        super(redius);
    }

    @Override
    public int compareTo(Object o) {
       if(this == o){
           return 0;
       }
       if(o instanceof ComparableCircle){
           ComparableCircle c = (ComparableCircle) o;
           // 错误的
           //  return (int) (c.getRedius() - this.getRedius());
           // 正确的方式一：
//           if(this.getRedius() > c.getRedius()){
//               return 1;
//           }else if(this.getRedius() < c.getRedius()){
//               return -1;
//           }else{
//              // return 0;
//               throw new RuntimeException("传入的数据类型不匹配");
//           }

           // 正确的方式二：
           // 当属性radius声明为Double类型时，可以调用包装类的方法
           return this.getRedius().compareTo(c.getRedius());
       }else{
           return 0;
       }
    }
}
