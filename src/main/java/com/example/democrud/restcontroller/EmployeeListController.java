package com.example.democrud.restcontroller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.democrud.entity.Employee;
import com.example.democrud.service.EmployeeService;

import java.util.List;

@Scope (value = "session")
@Component (value = "employeeList")
@ELBeanName(value = "employeeList")
@Join(path = "/", to = "/employee-list.jsf")
public class EmployeeListController {

    @Autowired
    private EmployeeService employeeService;

    private List<Employee> employees;

//    @Deferred
//    @RequestAction
//    @IgnorePostback
//    public void loadData() {
//    	employees = employeeService.getAllEmployees();
//    }

    public List<Employee> getEmployees() {
    	employees = employeeService.getAllEmployees();
        return employees;
    }
    public void delete(int id) {
    	employeeService.deleteById(id);
    }
    public void update(Employee employee) {
    	employeeService.save(employee);
    }
}
