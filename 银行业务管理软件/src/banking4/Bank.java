package banking4;

/**
 * @author Administrator
 */
public class Bank {
	/**
	 * 用于存放客户
	 */
	private Customer[] customers;
	/**
	 * 记录Customer的个数
	 */
	private int numberOfCustomers;

	public Bank(){
		customers = new Customer[5];
	}

	/**
	 * 添加一个Customer到数组中
	 * @param f
	 * @param l
	 */
	public void addCustomer(String f,String l){
		Customer cust = new Customer(f, l);
		customers[numberOfCustomers++] = cust;
	}

	/**
	 * 获取Customer的个数
	 * @return
	 */
	public int getNumOfCustomers(){
		return numberOfCustomers;
	}

	/**
	 * 返回指定索引位置的Customer
	 * @param index
	 * @return
	 */
	public Customer getCustomer(int index){
		return customers[index];
	}
}
