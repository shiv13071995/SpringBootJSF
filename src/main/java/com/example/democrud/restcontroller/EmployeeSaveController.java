package com.example.democrud.restcontroller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.democrud.entity.Employee;
import com.example.democrud.service.EmployeeService;

@Scope(value = "session")
@Component(value = "employeeController")
@ELBeanName(value = "employeeController")
@Join(path = "/employee", to = "/employee-form.jsf")
public class EmployeeSaveController {

    @Autowired
    private EmployeeService employeeService;

    private Employee employee = new Employee();

    public String save() {
    	employeeService.save(employee);
    	//employee = new Employee();
        return "/employee-list.xhtml?faces-redirect=true";
    }

    public Employee getEmployee() {
        return employee;
    }

}
