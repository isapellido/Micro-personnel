package net.praysam.demo1.mapper;

import net.praysam.demo1.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper {
    Employee findEmpById(Integer id);

    List<Employee> findEmpByIndex(int offset, int numbers);
}