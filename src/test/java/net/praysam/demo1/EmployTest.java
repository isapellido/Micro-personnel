package net.praysam.demo1;

import net.praysam.demo1.mapper.EmployeeMapper;
import net.praysam.demo1.pojo.Employee;
import net.praysam.demo1.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployTest {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeService employeeService;
    @Test
    public void testFindEmpById(){
        Employee emp = employeeService.findEmpById(1);
        System.out.println(emp.toString());
    }
    @Test
    public void testFindEmpByIndex(){
        List<Employee> emplist = employeeService.findEmpByIndex(0,10);
        System.out.println("查询结果数："+emplist.size());
        for (int i = 0; i<emplist.size();i++){
            System.out.println(emplist.get(i));
        }
    }
}
