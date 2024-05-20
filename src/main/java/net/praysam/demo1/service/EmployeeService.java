package net.praysam.demo1.service;

import net.praysam.demo1.mapper.EmployeeMapper;
import net.praysam.demo1.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    public Employee findEmpById(Integer id) {
        return employeeMapper.findEmpById(id);
    }

    public List<Employee> findEmpByIndex(int offset, int numbers) {
        return employeeMapper.findEmpByIndex(offset,numbers);
    }
}
