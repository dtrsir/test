package com.zhong.dao;

import com.zhong.pojo.Department;
import com.zhong.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*员工表dao层*/
@Repository
public class EmployeeDao {
    //模拟员工数据
    private static Map<Integer, Employee> employees = null;
    /*员工有所属的部门，需要外表*/
    @Autowired
    private DepartmentDao departmentDao;
    static {
        employees = new HashMap<>();

        employees.put(1001, new Employee(1001, "aa", "1212212@qq.com", 1, new Department(101, "教学部") ));
        employees.put(1002, new Employee(1002, "bb", "1212212@qq.com", 1, new Department(102, "市场部")));
        employees.put(1003, new Employee(1003, "cc", "1212212@qq.com", 1, new Department(103, "教研部")));
        employees.put(1004, new Employee(1004, "dd", "1212212@qq.com", 1, new Department(104, "运营部")));
        employees.put(1005, new Employee(1005, "ee", "1212212@qq.com", 1, new Department(105, "后勤部")));

    }
    /*模拟主键自增*/
    private static Integer initId = 1006;

    /*增加一个员工*/
    public void sava(Employee employee) {
        if (employee.getId()==null) {
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(), employee);

    }

    /*查询所有员工信息*/
    public Collection<Employee> getAllEmployee() {
        return employees.values();
    }

    /*通过id查询员工*/
    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    /*通过id删除员工*/
    public void deleteEmployeeById(Integer id) {
        employees.remove(id);
    }


}
