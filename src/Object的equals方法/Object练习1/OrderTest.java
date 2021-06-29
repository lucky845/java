package Object的equals方法.Object练习1;

/*
编写Order类,有int型的orderId,String型的orderName,相应的getter()和set()方法,
两个参数的构造器,重写父类的equals方法,并判断测试类中创建的两个对象是否相等.
 */
class Order {
    private int orderId;
    private String orderName;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Order() {

    }

    public Order(int orderId, String orderName) {
        this.orderName = orderName;
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof Order) {
            Order order = (Order) obj;

            return this.orderId == order.orderId && this.orderName.equals(order.orderName);
        }
        return false;
    }
}

public class OrderTest {
    public static void main(String[] args) {
        Order o1 = new Order(123, "牛呀");
        Order o2 = new Order(123, "牛呀");

        System.out.println(o1.equals(o2)); // true

        Order o3 = new Order(123, "牛啊");

        System.out.println(o1.equals(o3)); // false
    }

}