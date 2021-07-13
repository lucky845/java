package 泛型二;

import org.junit.Test;

import java.util.List;

/**
 * @author lichuang
 * @create 2021-07-13 17:08
 */
public class DAOTest {

    @Test
    public void test1(){
        CustomerDAO dao1 = new CustomerDAO();

        dao1.add(new Customer());
        List<Customer> list = dao1.getForList(10);


        StudentDAO dao2 = new StudentDAO();
        List<Student> list1 = dao2.getForList(1);
    }
}
