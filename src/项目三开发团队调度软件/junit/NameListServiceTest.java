package 项目三开发团队调度软件.junit;

import org.junit.Test;

import 项目三开发团队调度软件.domain.Employee;
import 项目三开发团队调度软件.service.NameListService;
import 项目三开发团队调度软件.service.TeamException;

public class NameListServiceTest {

    @Test
    public void testGetAllEmployees(){
        NameListService listService = new NameListService();

        Employee[] employees = listService.getAllEmployees();

        for(int i = 0;i < employees.length;i++){
            System.out.println(employees[i]);
        }
    }

    @Test
    public void testGetEmployee(){
        int id = 2;
        NameListService listService = new NameListService();
        try {
            Employee emp = listService.getEmployee(id);
            System.out.println(emp);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }
}
