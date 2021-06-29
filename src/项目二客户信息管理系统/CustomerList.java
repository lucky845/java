package 项目二客户信息管理系统;

/**
 * 内部封装一个Customer[],提供对Customer数据的增删改查操作
 * @author shkstart
 *
 */
public class CustomerList {
    private Customer[] customers;
    private int total  = 0; // 记录存储的客户的个数
    /**
     * 构造器，用来初始化customers数组
     * @param totalCustomer : 指定customers数组的最大空间
     */
    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
    }
    /**
     * 添加指定的客户到数组中
     * @param customer
     * @return 添加是否成功
     */
    public boolean addCustomer(Customer customer){
        if (total >= customers.length) return false;

        customers[total++] = customer;
        return true;
    }

    /**
     * 替换指定索引位置上的数组元素
     * @param index
     * @param cust
     * @return
     */

    public boolean replaceCustomer(int index,Customer cust){
        if (index < 0 || index >= total) return false;

        customers[index] = cust;
        return true;
    }

    /**
     * 删除指定索引位置上的元素
     * @param index
     * @return
     */

    public boolean deleteCustomer(int index){
        if (index < 0 || index >= total) return false;

        for (int i = index; i < total - 1; i++) {
            customers[i] = customers[i + 1];
        }

        customers[--total] = null;

        return true;
    }
    /**
     * 返回指定索引位置上的Customer
     * @param index
     * @return 如果输入的index位置上的元素不存在，返回null
     */
    public Customer getCustomer(int index) {
        if (index < 0 || index >= total) return null;

        return customers[index];
    }

    /**
     * 获取所有的customers对象构成的数组
     * @return
     */
    public Customer[] getAllCustomers(){
        Customer[] custs = new Customer[total];
        for (int i = 0; i < total; i++) {
            custs[i] = customers[i];
        }
        return custs;

    }
    /**
     * 返回Customer对象的个数
     * @return
     */
    public int getTotal() {
        //return customers.length;//错误的
        return total;
    }
}
