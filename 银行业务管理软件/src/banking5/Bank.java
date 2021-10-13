package banking5;

/**
 * @author Administrator
 */
public class Bank {
	//用于存放客户
	private Customer[] customers;
	//记录Customer的个数
	private int numberOfCustomers;
	
	public Bank(){
		customers = new Customer[5];
	}
	//添加一个Customer到数组中
	public void addCustomer(String f,String l){
		Customer cust = new Customer(f, l);
		customers[numberOfCustomers] = cust;
		numberOfCustomers++;
	}
	//获取Customer的个数
	public int getNumOfCustomers(){
		return numberOfCustomers;
	}
	//返回指定索引位置的Customer
	public Customer getCustomer(int index){
		return customers[index];
	}
}
