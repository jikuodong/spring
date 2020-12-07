package com.jkd.springboot.controller;

import com.jkd.springboot.dao.DepartmentDao;
import com.jkd.springboot.dao.EmployeeDao;
import com.jkd.springboot.entities.Department;
import com.jkd.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 *
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    // 查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        // 放在请求域中
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    // 来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        // 来到添加页面,查出所有的部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    // 添加员工
    // SpringMVC 自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的。
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        System.out.println("保存的员工信息：" + employee);
        // 保存员工
        employeeDao.save(employee);
        // 来到员工列表页面
        return "redirect:/emps";
    }

    // 来到修改页面，查出当前员工。在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        // 回到修改页面(add是一个修改添加二合一的页面)
        return "emp/add";
    }

    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println("修改的员工信息：" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return  "redirect:/emps";
    }
}
