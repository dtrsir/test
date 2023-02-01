package com.zhong.controller;


import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zhong.dao.DepartmentDao;
import com.zhong.dao.EmployeeDao;
import com.zhong.pojo.Department;
import com.zhong.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    //这里先调用dao层，没写service
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAllEmployee();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    //跳转到用户添加界面
    @GetMapping("/emp")
    public String toAddEmployeePage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/add";

    }

    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        employeeDao.sava(employee);//调用dao层保存员工信息
        return "redirect:/emps";

    }


    //跳转到员工修改页面
    @GetMapping("/emp/{id}")
    public String toUpdateEmployee(@PathVariable("id") int id, Model model) {

        //查询需要修改的用户信息
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("emp", employee);

        //查询部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/update";
    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(Employee employee) {
        employeeDao.sava(employee);
        return "redirect:/emps";
    }

    //删除员工
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeDao.deleteEmployeeById(id);

        return "redirect:/emps";

    }

}
