package net.praysam.demo1.controller;

import net.praysam.demo1.pojo.Employee;
import net.praysam.demo1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @RequestMapping("empMgr")
    public String getEmployees(Model model){
    Employee emp1 = employeeService.findEmpById(1);
    model.addAttribute("emp",emp1);

//    List<Employee> emplist = new ArrayList<Employee>();
//    emplist.add(new Employee(2,"john","男"));
//    emplist.add(new Employee(3,"paul","男"));
//    emplist.add(new Employee(4,"phoebe","女"));

        List<Employee> emplist = employeeService.findEmpByIndex(0, 10);

    model.addAttribute("emplist",emplist);
    return "empMgr";//跳转至empMgr.html页面
    }
}
